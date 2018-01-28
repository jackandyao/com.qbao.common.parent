package com.qbao.recommend.business.product.cmp.util;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 推荐会用到相关常量
 */
public class RecommendConstantUtil {


    /**
     * base buy
     */
    public final static String HOT_BUY_DIRECTORY="buy_directory_spu";
    public final static String HOT_BUY="hot_buy_spu";
    public final static String HOT_BUY_DOLE_DIST="buy_dole_spu";
    /**
     * base view
     */
    public final static String CLICK_SPU="click_spu";
    public final static String CLICK_AGAIN_SPU="click_again_spu";
    public final static String CLICK_BUY_SPU="click_buy_spu";
    public final static String CLICK_SIM_SPU="click_sim_spu";
    public final static String CLICK_DIRC_SPU="click_dirc_spu";
    public final static String CLICK_REALTIME_SPU="click_realtime_spu";

    /**
     * icf_spu,als_spu,fpg_spu,conent_spu
     */
    public final static String ICF_SPU="icf_spu";
    public final static String FPG_SPU="fpg_spu";
    
    /**
     * spu_maual
     */
    public final static String SPU_MANUAL="";
    /**
     * spu_emergcy
     */
    public final static String SPU_EMERGCY="";
    
    
    /**
     * spu_realtime
     */
    public final static String SPU_REALTIME_DIR="spu_realtime_dir";
    public final static String SPU_REALTIME_SIM="spu_realtime_sim";
    
    /**
     * dis
     */
    public final static String USER_DIS="user_dis";

    /**
     * price_handler,status_handler ,duplicate_handler
     */
    public final static String HANDLER = "handler";
    
    public final static String PRICE_HANDLER="price_handler";
    public final static String STATUS_HANDLER="status_handler";
    public final static String DUPLICATE_HANDLER="duplicate_handler";
    public final static String BUYFILTER_HANDLER="filterbuy_handler";
    public final static String SHUFFLE_HANDLER = "shuffle_handler";
    public final static String EXCLUDE_HANDLER = "exclude_handler";


    /**
     *  spu_buy spu_knowledge spu_personalized spu_view
     */
    public final static String FACADE_SPU_BUY="spu_buy_facade";
    public final static String FACADE_SPU_KNOWLEDGE="spu_knowledge_facade";
    public final static String FACADE_SPU_PERSONALIZED="spu_personlaized_facade";
    public final static String FACADE_SPU_VIEW="spu_view_facade";

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
     * 相似产品 关联目录
     */
    public final  static String IS_SIMILAR="is_similar";
    public final  static String IS_DIRECTORY="is_directory";
    
    /**
     * 数据补全策略
     */
    public final static String COMPLETION = "completion" ;
    
    public final static String HOT_DATA_COMPLETION="hot_completion";
    public final static String VIEW_DATA_COMPLETION="view_completion";
    
    /**
     * 模块显示记录数
     */
    public final static String MOUDLE_SIZE="moudle_size";
    
    public final static String ANNO_HOT_BUY_STRATEGY="hotSpuDataCompletionStrategy";
    public final static String ANNO_HOT_VIEW_STRATEGY="viewSpuDataCompletionStrategy";
    
    public final static String ANNO_SPU_DUPLICATE_HANDLE="spuDuplicateHandler";
    public final static String ANNO_SPU_STATUS_HANDLE="spuStatusHandler";
    public final static String ANNO_SPU_PRICE_HANDLE="spuPriceHandler";
    public final static String ANNO_SPU_FILTERBUY_HANDLE="spuFilterbuyHandler";
    public final static String ANNO_SPU_EXCLUDE_HANDLER="excludeHandler";
    public final static String ANNO_SPU_SHUFF_HANDLE="spuShuffHandler";
    
    
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
    
    public static final String COM_SPU_ID="spuId";
    public static final String COM_SPU_TYPE="spuType";
    
    public static final String SHUFFLE_TYPE="shuff_type";
    
    
     

    
}
