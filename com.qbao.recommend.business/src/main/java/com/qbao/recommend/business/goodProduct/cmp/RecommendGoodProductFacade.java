package com.qbao.recommend.business.goodProduct.cmp;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.goodProduct.cmp.service.IGoodsLikesService;
import com.qbao.recommend.business.goodProduct.cmp.service.IGoodsStatService;
import com.qbao.recommend.business.goodProduct.model.KPI;
import com.qbao.recommend.business.goodProduct.model.Label;
import com.qbao.recommend.business.goodProduct.rest.dto.GoodsLikesDTO;
import com.qbao.recommend.business.goodProduct.rest.dto.KpiDTO;
import com.qbao.recommend.business.goodProduct.rest.dto.PerformanceDTO;
import com.qbao.recommend.business.goodProduct.util.LabelUtils;
import com.qbao.recommend.business.goodProduct.util.URLUtils;
import com.qbao.recommend.respositoy.mysql.model.*;
import com.qbao.recommend.respositoy.mysql.page.Page;
import com.qbao.recommend.respositoy.mysql.service.*;
import com.qbao.recommend.respositoy.restful.entities.GoodGoods;
import com.qbao.recommend.respositoy.restful.service.IHaohuoSearchService;
import com.qbao.recommend.util.channel.ChannelConstantUtils;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

/**
 * sjzhangjun
 * 封装推荐对外的最终服务接口
 */
@Component
public class RecommendGoodProductFacade {

    //public final static String WEISHANGDETAILURL = "http://m.qbao.com/wswap/productShare.htm?spuId=";
    private static DecimalFormat df = new DecimalFormat("0.00");
    private Logger spuFacadeWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.good_product, Level.WARN);


    private float minHaoHuoScore = 35.0f;
    private long minPrice = 2000; //BaoBi

    private String defaultUrl = "/search_v2/api/haohuo/list" ;

    @Autowired
    private IGoodsStatService iGoodsStatService;

    @Autowired
    private IGoodsLikesService iGoodsLikesService;

    @Autowired
    private IGRankService iGRankService;

    @Autowired
    private IGRankThumbService igRankThumbService;

    @Autowired
    private IGRankSearchService iGRankSearchService;

    @Autowired
    private IGRankFavoriteService iGRankFavoriteService;

    @Autowired
    private IGRankReturnService iGRankReturnService;

    @Autowired
    private IGRankViewService iGRankViewService;

    @Autowired
    private IGRankBuyService iGRankBuyService;

    @Autowired
    private IMerDirectoryService iMerDirectoryService;

    @Autowired
    private IMerMiddleDataService iMerMiddleDataService;

    @Autowired
    private IHotSpuService hotSpuService;

    @Autowired
    private IGoodProductDirService goodProductDirService;

    @Autowired
    private IHaohuoSearchService haohuoSearchService;

    public RecGoodProduct getGoodProduct(long goodsId) {
        return iGoodsStatService.getGoodsStatBySpuId(goodsId);
    }

    public PerformanceDTO fetchGoodProduct(long goodsId) {
        PerformanceDTO dto = null;
        RecGoodProduct recGoodProduct = getGoodProduct(goodsId);
        if (null != recGoodProduct) {
            Long spuId = recGoodProduct.getSpuId();
            SpuInfoMerchant spuInfoMerchant = iMerMiddleDataService.findBySpuIdIgnoreStatus(spuId);
            spuFacadeWarnLogger.warn(" spuId = [" + spuId + "] is found in IMerMiddleDataService  = " + (null != spuInfoMerchant));
            dto = new PerformanceDTO();
            dto.setGoodsId(recGoodProduct.getSpuId());
            //商品中间表查不到数据情况. 概率极少
            dto.setGoodsName((null != spuInfoMerchant) ? spuInfoMerchant.getSpuName() : "");
            dto.setReport(recGoodProduct.calReport());
            dto.setSoldRate(recGoodProduct.calSoldRate());
            dto.setSellTrend(recGoodProduct.calSellTrend());
        }
        return dto;
    }

    public List<GoodsLikesDTO> fetchGoodsLikes(long goodsId, int size) {
        List<GoodsLikesDTO> result = Lists.newLinkedList();
        int limit = size * 10; //获取更多商品,避免下架
        List<RecGoodProduct> recGoodProducts = iGoodsLikesService.getGoodsLikesBySpuId(goodsId, limit);
        for (RecGoodProduct product : recGoodProducts) {
            Long spuId = product.getSpuId();
            size = addVaildSpuGoodsLikesDTO(result, size, spuId);
            if (size < 0) {
                break;
            }
        }
        if (result.size() < size) {
            int addtionalSize = size - result.size();
            spuFacadeWarnLogger.warn("GoodGoods likes result size [" + result.size() + "] <  expected size [" + size + "], need  add [" + addtionalSize + "] hot sale to complement");
            complement(result, addtionalSize);
        }
        //按照分数排序
        Collections.sort(result);
        return result;
    }

    public KpiDTO fetchGoodsKpi(long goodsId) {
        KpiDTO dto = null;
        RecGoodProduct recGoodProduct = getGoodProduct(goodsId);
        if (null != recGoodProduct) {
            Long spuId = recGoodProduct.getSpuId();

            SpuInfoMerchant spuInfoMerchant = iMerMiddleDataService.findBySpuId(spuId);
            spuFacadeWarnLogger.warn(" spuId = [" + spuId + "] is found in IMerMiddleDataService  = " + (null != spuInfoMerchant) + " and the value : " + spuInfoMerchant);
            if (null != spuInfoMerchant) {
                dto = new KpiDTO();
                dto.setGoodsId(recGoodProduct.getSpuId());
                dto.setGoodsPic(spuInfoMerchant.getMainImg());
                dto.setCompleteCount(spuInfoMerchant.getSellCountAggregated());
                dto.setCollectTimes(spuInfoMerchant.getFavoriteNum());
                dto.setGoodsName(spuInfoMerchant.getSpuName());
                dto.setReceiveTime(String.valueOf((int) calRecieveTime(recGoodProduct.getArriveTime())));
                dto.setRepeatBuyRate(String.valueOf(recGoodProduct.calRePurchaseRate()));
                dto.setSupportTimes(spuInfoMerchant.getSpuThumb());
                dto.setUpdateTime((null != recGoodProduct.getUpdateTime()) ? DateFormatUtils.format(recGoodProduct.getUpdateTime(), "yyyy-MM-dd HH:mm:ss") : StringUtils.EMPTY);
                dto.setGoodsKpi(calKPIs(recGoodProduct.getSpuId()));
                dto.setLabels(calLabels(recGoodProduct.getSpuId()));
                dto.setTotalScore(calGoodsScore(recGoodProduct.getSpuId()));
                dto.setBuyUrl(URLUtils.generateDetailUrl(recGoodProduct.getSpuId(), ChannelConstantUtils.GOODS_LIKES_CHANNEL));
                dto.setGoodsSource("HaoHuo");
                dto.setCollectUrl(StringUtils.EMPTY);
                dto.setShareUrl(StringUtils.EMPTY);
                dto.setSupportUrl(StringUtils.EMPTY);
            }
        }
        return dto;
    }


    /**
     * 获取有好货分类列表
     * @return
     */
    public List<GoodProductDir> findHaohuoClasses(){
       return  goodProductDirService.findList();
    }

    public Page<GoodGoods> findHaohuoPage(long cid,String kw, int page, int size) {
        if(cid == 0){
            try {
                return haohuoSearchService.findList(defaultUrl+"?kw="+URLEncoder.encode(kw,"utf-8"),page,size);
            } catch (IOException e) {
                spuFacadeWarnLogger.error(ExceptionUtils.getFullStackTrace(e));
                throw new RuntimeException("系统错误！ 获取列表数据失败！");
            }
        }
        GoodProductDir dir = goodProductDirService.findById(cid);
        if(dir != null){
            String url = dir.getUrl();
            try {
                if(url.contains("?")){
                    url+="&kw="+ URLEncoder.encode(kw,"utf-8");
                }else{
                    url+="?kw="+ URLEncoder.encode(kw,"utf-8");
                }

                return haohuoSearchService.findList(url,page,size);
            } catch (IOException e) {
                spuFacadeWarnLogger.error(ExceptionUtils.getFullStackTrace(e));
                throw new RuntimeException("系统错误！ 获取列表数据失败！");
            }
        }else{
            throw new RuntimeException("系统错误！ 没有此分类信息！");
        }
    }

    private Double calGoodsScore(long spuId) {
        Double score = 0.00;
        GRank rank = iGRankService.findBySpuId(spuId);
        if (null != rank) {
            score = Double.valueOf(df.format(rank.getScore()));
        }
        spuFacadeWarnLogger.warn(" spuId = [" + spuId + "]  score : [" + score + "]");
        return score;
    }

    private double calRecieveTime(long time) {
    	double day = Math.floor(time * 10 / (60 * 24) / 10.0);
        return (day<1)?1:day;
    }

    private void complement(List<GoodsLikesDTO> result, int expectedSize) {
        List<Long> spuIds = hotSpuService.findAllSpuIdofHotSpuMerchant();
        for (Long spuId : spuIds) {
            if (expectedSize < 0) {
                break;
            }
            expectedSize = addVaildSpuGoodsLikesDTO(result, expectedSize, spuId);
        }

    }

    private int addVaildSpuGoodsLikesDTO(List<GoodsLikesDTO> result, int expectedSize, Long spuId) {
        SpuInfoMerchant spuInfoMerchant = iMerMiddleDataService.findBySpuId(spuId);
        spuFacadeWarnLogger.warn(" check spuId = [" + spuId + "] status in IMerSpuService  and the spu is valid = " + (null != spuInfoMerchant));
        if (expectedSize > 0 && null != spuInfoMerchant) {
            GoodsLikesDTO dto = new GoodsLikesDTO();
            dto.setSpuId(spuInfoMerchant.getSpuId());
            dto.setGoodsName(spuInfoMerchant.getSpuName());
            dto.setGoodsPic(spuInfoMerchant.getMainImg());
            boolean isHaoHuo = isHaobao(spuInfoMerchant.getSpuId(), spuInfoMerchant);
            dto.setHaohuo(isHaoHuo);
            dto.setGoodsPicLink( isHaoHuo ? URLUtils.generateHaoHuolUrl(spuInfoMerchant.getSpuId(), ChannelConstantUtils.GOODS_LIKES_CHANNEL) : URLUtils.generateDetailUrl(spuInfoMerchant.getSpuId(), ChannelConstantUtils.GOODS_LIKES_CHANNEL));
            dto.setGoodKpi(calGoodsScore(spuInfoMerchant.getSpuId()));
            result.add(dto);
            expectedSize--;
        }
        return expectedSize;
    }

    private List<KPI> calKPIs(long spuId) {
        List<KPI> kpis = Lists.newLinkedList();
        kpis.add(getSearchKPI(spuId));
        kpis.add(getBuyKPI(spuId));
        kpis.add(getFavoriteKPI(spuId));
        kpis.add(getReturnKPI(spuId));
        kpis.add(getThumbKPI(spuId));
        kpis.add(getViewKPI(spuId));
        return kpis;
    }

    private KPI getSearchKPI(long spuId) {
        KPI kpi = new KPI();
        kpi.setSortId(1);
        double score = 0.0;
        GRank rank = iGRankSearchService.findBySpuId(spuId);
        if (null != rank) {
            score = rank.getScore();
        }
        kpi.setScore(Double.valueOf(df.format(score)));
        kpi.setName("产品热度");
        kpi.setContent(StringUtils.EMPTY);
        return kpi;
    }

    private KPI getThumbKPI(long spuId) {
        KPI kpi = new KPI();
        kpi.setSortId(5);
        double score = 0.0;
        GRank rank = igRankThumbService.findBySpuId(spuId);
        if (null != rank) {
            score = rank.getScore();
        }
        kpi.setScore(Double.valueOf(df.format(score)));
        kpi.setName("产品获赞");
        kpi.setContent(StringUtils.EMPTY);
        return kpi;
    }

    private KPI getReturnKPI(long spuId) {
        KPI kpi = new KPI();
        kpi.setSortId(4);
        //Default value 10.0
        double score = 10.0;
        GRank rank = iGRankReturnService.findBySpuId(spuId);
        if (null != rank) {
            score = rank.getScore();
        }
        kpi.setScore(Double.valueOf(df.format(score)));
        kpi.setName("产品投诉");
        kpi.setContent(StringUtils.EMPTY);
        return kpi;
    }

    private KPI getBuyKPI(long spuId) {
        KPI kpi = new KPI();
        kpi.setSortId(2);
        double score = 0.0;
        GRank rank = iGRankBuyService.findBySpuId(spuId);
        if (null != rank) {
            score = rank.getScore();
        }
        kpi.setScore(Double.valueOf(df.format(score)));
        kpi.setName("产品销量");
        kpi.setContent(StringUtils.EMPTY);
        return kpi;
    }

    private KPI getFavoriteKPI(long spuId) {
        KPI kpi = new KPI();
        kpi.setSortId(3);
        double score = 0.0;
        GRank rank = iGRankFavoriteService.findBySpuId(spuId);
        if (null != rank) {
            score = rank.getScore();
        }
        kpi.setScore(Double.valueOf(df.format(score)));
        kpi.setName("用户关注");
        kpi.setContent(StringUtils.EMPTY);
        return kpi;
    }

    private KPI getViewKPI(long spuId) {
        KPI kpi = new KPI();
        kpi.setSortId(6);
        double score = 0.0;
        GRank rank = iGRankViewService.findBySpuId(spuId);
        if (null != rank) {
            score = rank.getScore();
        }
        kpi.setScore(Double.valueOf(df.format(score)));
        kpi.setName("浏览热度");
        kpi.setContent(StringUtils.EMPTY);

        return kpi;
    }

    private List<Label> calLabels(long spuId) {
        List<Label> lables = Lists.newArrayList();
        RecGoodProduct recGoodProduct = iGoodsStatService.getGoodsStatBySpuId(spuId);
        MerDirectory merDirectory = iMerDirectoryService.findByDirId(recGoodProduct.getDirId());
        if (null != merDirectory) {
            if (StringUtils.isNotBlank(merDirectory.getDirName())) {
                Label label = new Label();
                label.setSortId(1);
                label.setLable(LabelUtils.formatLabel(merDirectory.getDirName()));
                lables.add(label);
            }

            if (StringUtils.isNotBlank(merDirectory.getMainDirName())) {
                Label label = new Label();
                label.setSortId(2);
                label.setLable(LabelUtils.formatLabel(merDirectory.getMainDirName()));
                lables.add(label);
            }
        }
        return lables;
    }

    private boolean isHaobao(long spuId, SpuInfoMerchant spuInfoMerchant) {
        boolean result = false;
        if (null != spuInfoMerchant &&
                spuInfoMerchant.getViewPrice() >= minPrice &&
                calGoodsScore(spuId) >= minHaoHuoScore) {
            result = true;
        }
        return result;
    }



    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(Double.valueOf(df.format(48.002)));
        System.out.println(URLEncoder.encode("","utf-8"));
//        List<GoodsLikesDTO> lists = new ArrayList<>();
//        GoodsLikesDTO  dto = new GoodsLikesDTO();
//        dto.setSpuId(1100L);
//        dto.setGoodKpi(10.1);
//        lists.add(dto);
//        dto = new GoodsLikesDTO();
//        dto.setSpuId(200L);
//        dto.setGoodKpi(20.1);
//        lists.add(dto);
//
//        dto = new GoodsLikesDTO();
//        dto.setSpuId(300L);
//        dto.setGoodKpi(0.1);
//        lists.add(dto);
//
//        dto = new GoodsLikesDTO();
//        dto.setSpuId(400L);
//        dto.setGoodKpi(11.1);
//        lists.add(dto);
//
//        Collections.sort(lists);
//
//        for(GoodsLikesDTO item: lists ){
//            System.out.println(item);
//        }

    }
}
