/**
 * 
 */
package com.qbao.recommend.stream.cmp.handler.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.qbao.recommend.respositoy.redis.IRedisService;
import com.qbao.recommend.respositoy.redis.common.RedisModel;
import com.qbao.recommend.respositoy.redis.factory.RedisModelFactory;
import com.qbao.recommend.respositoy.redis.model.ItemDTO;
import com.qbao.recommend.respositoy.redis.model.goods.mer.MerProductStatus;
import com.qbao.recommend.stream.cmp.domain.maxwell.BcProductBinLogInfo;
import com.qbao.recommend.stream.cmp.domain.maxwell.MerSpuBinLogInfo;
import com.qbao.recommend.stream.cmp.domain.monitor.MerSpuStatus;
import com.qbao.recommend.stream.cmp.enums.BinLogOperationType;
import com.qbao.recommend.stream.cmp.handler.IHandler;
import com.qbao.recommend.stream.cmp.parser.KafkaParser;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
@Service
public class MonitorHandlerImpl implements IHandler {
    
    public static final int REDIS_EXPIRE = 600; // 10min
    @Autowired
    private IRedisService iRedisService;

    private KafkaParser<?> parser;

    @Override
    public boolean process(String message) {
        kafkaInfoLogger.info("Monitor Hander the message: " + message);
        if (StringUtils.isNotBlank(message)) {
            Object binlog = parser.parse(message);
            if (binlog instanceof BcProductBinLogInfo) {
                monitorBcProduct((BcProductBinLogInfo) binlog);
            } else if (binlog instanceof MerSpuBinLogInfo) {
                monitorMerSpu((MerSpuBinLogInfo) binlog);
            } else {
                kafkaErrorLogger.error("parser the message to object is not valid object : " + message);
                return false;
            }

        }
        return true;
    }

    @Override
    public void init() {

    }

    @Override
    public KafkaParser<?> getParser() {
        return parser;
    }

    @Override
    public void setParser(KafkaParser<?> parser) {
        this.parser = parser;
    }

    @SuppressWarnings("unused")
    private void monitorMerSpu(MerSpuBinLogInfo binLog) {
        if (null == binLog || null == binLog.getData()) {
            return;
        }
        MerProductStatus merProduct = null;
        RedisModel<?> model = null;
        MerSpuStatus merSpuStatus = binLog.getData();
        Long spuId = merSpuStatus.getSpuId();
        
        RedisModel<MerProductStatus> queryModel = (RedisModel<MerProductStatus>) RedisModelFactory.getQueryModel(String.valueOf(spuId), MerProductStatus.class);
        Preconditions.checkNotNull(iRedisService);
        @SuppressWarnings("unchecked")
        RedisModel<MerProductStatus> targetModel = (RedisModel<MerProductStatus>) iRedisService.find(queryModel);
        if (null == targetModel || null == targetModel.getValue() ) {
            switch (BinLogOperationType.asBinLogOperationType(binLog.getType())) {
            case INSERT :
            case UPDATE :
                if (merSpuStatus.getPublishStatus() == 1) { // 上架
                    kafkaInfoLogger.info("saving spu_id ["+ spuId+"] to redis and the operating type = " + binLog.getType() );
                    ItemDTO dto =new ItemDTO(merSpuStatus.getSpuId(),merSpuStatus.getMainImg(),merSpuStatus.getViewPrice(),merSpuStatus.getSpuName(),merSpuStatus.getSellCountAggregated());
                    merProduct = new MerProductStatus(spuId,dto);
                    model = RedisModelFactory.getRedisModel(String.valueOf(spuId), merProduct);
                    iRedisService.save(model,REDIS_EXPIRE);
                }
                break;
            default:    
                break;
            }
        } else {
            merProduct = targetModel.getValue();
            java.util.Date mysqlBinlogDate= new java.util.Date((binLog.getTs()*1000));
            // kafka binlog no delay that the binlog value is valid
            kafkaInfoLogger.info("spu_id= ["+spuId+"] binLog date = " + mysqlBinlogDate+ " and operating type = " + binLog.getType() );
            kafkaInfoLogger.info("spu_id= ["+spuId+"] in redis update time = " + merProduct.getUpdateTime() +",["+merProduct.getUpdateTime().getTime() +"]"+ " and operating type = " + binLog.getType() );
            if (mysqlBinlogDate.getTime() > merProduct.getUpdateTime().getTime()) {
                merProduct.setUpdateTime(new Date());
                model = RedisModelFactory.getRedisModel(String.valueOf(spuId), merProduct);
                kafkaInfoLogger.info("获取到一个最终结果 : " + model.getKey());
                switch (BinLogOperationType.asBinLogOperationType((binLog.getType()))) {
                //
                // case INSERT:
                // iRedisService.save(model);
                // break;
                case DELETE:
                    kafkaInfoLogger.info("deleting the spu_id=["+spuId+"] from redis and the operating type = " + binLog.getType() );
                    iRedisService.delete(model);
                   
                    break;
                case UPDATE:
                    // 上架或者下架逻辑 if(binLog.getOld())
                    if (binLog.getData().getPublishStatus() == 1) { // 上架
                        kafkaInfoLogger.info("saving the spu_id=["+spuId+"] to redis and the operating type = " + binLog.getType() );
                        ItemDTO dto =new ItemDTO(merSpuStatus.getSpuId(),merSpuStatus.getMainImg(),merSpuStatus.getViewPrice(),merSpuStatus.getSpuName(),merSpuStatus.getSellCountAggregated());
                        merProduct = new MerProductStatus(spuId,dto);
                        //update the spu info
                        model = RedisModelFactory.getRedisModel(String.valueOf(spuId), merProduct);
                        iRedisService.save(model,REDIS_EXPIRE);
                    } else {
                        kafkaInfoLogger.info("deleting the spu_id=["+spuId+"] from redis and the operating type =" + binLog.getType() );
                        iRedisService.delete(model);
                    }
                    break;
                default:
                    kafkaErrorLogger.error("error to handle the binlog " + binLog);
                    break;
                }
            }
        }

    }

    private void monitorBcProduct(BcProductBinLogInfo binLog) {

    }


    public static void main(String[] args) {
        RedisModel<?> queryModel = RedisModelFactory.getQueryModel(String.valueOf(1212112), MerProductStatus.class);
        // super.get(model.getTableName(), model.getKey(), model.getValue().getClass())
        System.out.println(queryModel);
        System.out.println(queryModel.getKey());
        System.out.println(queryModel.getTableName());
        System.out.println(queryModel.getValue().getClass());
    }

}
