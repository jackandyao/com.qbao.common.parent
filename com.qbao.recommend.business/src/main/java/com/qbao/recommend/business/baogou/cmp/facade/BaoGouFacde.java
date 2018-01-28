package com.qbao.recommend.business.baogou.cmp.facade;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qbao.recommend.business.baogou.cmp.util.BaoGouConstantUtil;
import com.qbao.recommend.business.baogou.cmp.util.ParametersUtil;
import com.qbao.recommend.business.baogou.rest.dto.BaoGouGrankDto;
import com.qbao.recommend.business.baogou.rest.dto.TopViewSpuDto;
import com.qbao.recommend.respositoy.mysql.model.GRank;
import com.qbao.recommend.respositoy.mysql.model.HotSpuSearch;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoBaogou;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import com.qbao.recommend.respositoy.mysql.service.*;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * @author wangping
 * @createTime 下午2:57
 * $$LastChangedDate: 2016-11-22 17:49:03 +0800 (Tue, 22 Nov 2016) $$
 * $$LastChangedRevision: 1440 $$
 * $$LastChangedBy: shuaizhihu $$
 */
@Component
public class BaoGouFacde {
    private Logger infoLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_gou, Level.INFO);
    private Logger errorLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_gou, Level.ERROR);
    private static DecimalFormat df = new DecimalFormat("0.00");
    @Autowired
    private IHotSpuService hotSpuService;
//    @Autowired
//    private IMerSpuService merSpuService;
    @Autowired
    private IMerMiddleDataService merMiddleData;
    @Autowired
    private IBcProductService bcProductService;

    @Autowired
    private IGRankService grankService;

    @Autowired
    private IMerchantGoodStatDayService iMerchantGoodStatDayService;

    public List<TopViewSpuDto> fetchTopViewSpu(Map<String, Object> requestParams, JSONObject context) {
        List<TopViewSpuDto> result = Lists.newArrayList();
        Integer limit = (Integer) ParametersUtil.getParameter(requestParams, BaoGouConstantUtil.LIMIT);
        List<HotSpuSearch> hotSpuSearches = hotSpuService.getALLHotSpuSearch();
        infoLogger.info("total get hot spu searches size : " +hotSpuSearches.size());
        if (CollectionUtils.isNotEmpty(hotSpuSearches)) {
            for (HotSpuSearch hotSpuSearch : hotSpuSearches) {
                if (result.size() >= limit) {
                    break;
                }
                TopViewSpuDto dto = HotSpuSearchToTopViewSpuDto(hotSpuSearch);
                if (null != dto) {
                    result.add(dto);
                }
            }
        }
        return result;
    }



    public BaoGouGrankDto fetchHaoHuoIndex(long baoGouId){
        BaoGouGrankDto grankDto = null;
        SpuInfoBaogou baogou = bcProductService.findById(baoGouId);
        if(null != baogou){
            infoLogger.info("Bao gou id ["+baoGouId+ "] is online");
            GRank grank = grankService.findBySpuId(baogou.getSpuId());
            if(null !=grank){
                infoLogger.info("Grank is found  baogou id = ["+baoGouId+ "], and  spuId = ["+baogou.getSpuId()+"]");
                grankDto = new BaoGouGrankDto();
                grankDto.setBaoGouId(baoGouId);
                grankDto.setSpuId(grank.getSpuId());
                grankDto.setScore(Double.valueOf(df.format(grank.getScore())));
            }
        }
        return grankDto;
    }

    public long findTotalSaleNumBySpuId(long spuId,String startDate,String endDate){
        return iMerchantGoodStatDayService.findOrderNumBySpuId(spuId,startDate,endDate);
    }


//    public List<BaoGouGrankDto> fetchAllHaoHuoIndex(Map<String, Object> requestParams, JSONObject context){
//        List<BaoGouGrankDto> result = Lists.newArrayList();
//        List<Long> spuIds = bcProductService.findSellingAll();
//        if(CollectionUtils.isNotEmpty(spuIds)){
//            for(Long spuId : spuIds){
//                GRank grank = grankService.findBySpuId(spuId);
//                if(null != grank){
//                    BaoGouGrankDto dto = new BaoGouGrankDto();
//
//                }
//            }
//        }
//        return result;
//    }

    private TopViewSpuDto HotSpuSearchToTopViewSpuDto(HotSpuSearch hotSpuSearch) {
        TopViewSpuDto dto = null;
        if (null != hotSpuSearch) {
            infoLogger.info("process.. " + hotSpuSearch);
            long goodsId = hotSpuSearch.getGoodsId(); //宝购ID或微商ID
            int isBaogou = hotSpuSearch.getIsBaoGou(); // 1 宝购
            long spuId = goodsId;
            Long baoGouId = null;
            if (isBaogou == 1) {
                baoGouId = goodsId;
                SpuInfoBaogou baogou = bcProductService.findSellingById(baoGouId);
                if (null != baogou) {
                    spuId = baogou.getSpuId();
                    infoLogger.info("Bao gou id ["+baoGouId+ "] is online");
                }else {
                    infoLogger.info("Bao gou id ["+baoGouId+ "] is offline");
                }
            }
            SpuInfoMerchant spuInfo = merMiddleData.findBySpuId(spuId);
            if (null != spuInfo) {
                dto = new TopViewSpuDto();
                dto.setSpuId(spuId);
                dto.setBaogouId(baoGouId);
                dto.setIsBaogou(isBaogou);
                dto.setCurrentLv(spuInfo.getAccountType());
                dto.setSpuImg(spuInfo.getMainImg());
                dto.setSpuName(spuInfo.getSpuName());
                dto.setSpuPrice(spuInfo.getViewPrice());
                dto.setSpuSellnumber(spuInfo.getSellCountAggregated());
                dto.setSpuStock(spuInfo.getReserveCount());
                infoLogger.info("Merchant  goods id ["+spuId+ "] is online");
            }else {
                infoLogger.info("Merchant  goods id ["+spuId+ "] is offline");
            }
        }
        return dto;
    }


}
