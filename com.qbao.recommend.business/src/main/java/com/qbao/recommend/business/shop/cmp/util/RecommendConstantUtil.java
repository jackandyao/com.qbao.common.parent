package com.qbao.recommend.business.shop.cmp.util;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 推荐会用到相关常量
 */
public class RecommendConstantUtil {


    /**
     * base buy
     */
    public final static String SHOP_BUY="shop_buy";
    /**
     * base view
     */
    public final static String SHOP_VIEW="shop_view";

    /**
     * base prd
     */
    public final static String SHOP_PRD="shop_prd";
    
    /**
     * shop_maual
     */
    public final static String SHOP_MANUAL="";
    /**
     * shop_emergcy
     */
    public final static String SHOP_EMERGCY="";
    
    /**
     * base icf
     */
    public final static String SHOP_ICF="shop_icf";

    /**
     * price_handler,status_handler ,duplicate_handler
     */
    public final static String HANDLER = "handler";
    
    public final static String PRICE_HANDLER="price_handler";
    public final static String STATUS_HANDLER="status_handler";
    public final static String DUPLICATE_HANDLER="duplicate_handler";
    public final static String BUYFILTER_HANDLER="filterbuy_handler";
    public final static String SHUFFLE_HANDLER = "shuffle_handler";


    /**
     *  shop_buy shop_icf shop_prd shop_view
     */
    public final static String FACADE_SHOP_BUY="shop_buy_facade";
    public final static String FACADE_SHOP_ICF="shop_icf_facade";
    public final static String FACADE_SHOP_PRD="shop_prd_facade";
    public final static String FACADE_SHOP_VIEW="shop_view_facade";

    /**
     * vistor_user  anyoums_user behavior_user login_user
     */

    public final static String VISITOR_USER="vistor_user";
    public final static String ANOYOUMS_USER="anyoums_user";
    public final static String BEHAVIOR_USER="behavior_user";
    public final static String LOGIN_USER="login_user";

    /**
     * params user_id spu_id current_page page_size keyWord device_type ip_adress visit_time
     */
    public final static String USER_ID="user_id";
    public final static String SPU_ID="spu_id";
    public final static String CURRENT_PAGE = "current_page";
    public final static String PAGE_SIZE = "page_size";
    public final static String KEYWORD = "keyWord";
    public final static String DEVICE_TYPE = "device_type";
    public final static String IP_ADDRESS ="ip_address";
    public final static String VISIT_TIME="visit_time";
    
    public final static String META_DATA="meta_data";
    
    public final static String COMPLETION_DATA_TYPE="cmp_type";
    public final static String LIMIT_SIZE="limit_size";

    /**
     * interface falg
     */
    public final static String GUESS_LIKE="guess_like";





    public final static String SEARCH_KEY_WORD="keyword";
    
    public final static String SHOW_NUM="num";

    /**
     * 数据补全策略
     */
    public final static String COMPLETION = "completion" ;
    
    public final static String HOT_DATA_COMPLETION="hot_completion";
    
    /**
     * 模块显示记录数
     */
    public final static String MOUDLE_SIZE="moudle_size";
    
    public final static String ANNO_HOT_SHOP_STRATEGY="hotShopDataCompletionStrategy";
    
    public final static String ANNO_SHOP_DUPLICATE_HANDLE="shopDuplicateHandler";
    public final static String ANNO_SHOP_STATUS_HANDLE="shopStatusHandler";
    public final static String ANNO_SHOP_PRICE_HANDLE="shopPriceHandler";
    public final static String ANNO_SHOP_FILTERBUY_HANDLE="shopFilterbuyHandler";
    
    
    public static final int REDIS_EXPIRE_TIME = 600; // 10min
   
    
    /**
     * 混排key
     */
    public static final String SHUFFLE_DATA = "shuff_data";
    public static final String SHUFFLE_PAGESIZE="shuff_page_size";
    public static final String SHUFFLE_PIT="shuff_pit";
    public static final String SHUFFLE_PIT_INDEX="shuff_pit_index";
    public static final String SHUFFLE_PIT_DATA_SERVICE="shuff_pit_spu_service";
    public static final String SHUFFLE_INTERVAL = "shuffle_interval";
    
    
    /**
     * 数据补全-混排-急救 类型后缀标志
     */
    public static final String DATA_SHUFFLE="Shuffle";
    public static final String DATA_COMPLETE="Complete";
    public static final String DATA_EMERGENCY="Emergency";
    public static final String DATA_HANDLER="Handler";
    
    public static final String COM_SHOP="shop";
    public static final String COM_SHOP_TYPE="shopType";
    
    public static final String SHUFFLE_TYPE="shuff_type";
    
    
     

    
}
