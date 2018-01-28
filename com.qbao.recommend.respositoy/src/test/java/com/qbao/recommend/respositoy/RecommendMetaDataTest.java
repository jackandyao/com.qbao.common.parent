package com.qbao.recommend.respositoy;

import com.qbao.recommend.respositoy.mysql.model.*;
import com.qbao.recommend.respositoy.mysql.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试获取推荐元数据
 * 
 * @author 贾红平
 * $LastChangedDate: 2016-10-25 18:18:38 +0800 (Tue, 25 Oct 2016) $
 * $LastChangedRevision: 1305 $
 * $LastChangedBy: zhangjun $
 */
public class RecommendMetaDataTest {
    public static void main(String[] args) {
        // String[]path=new String[]{"dubbo/task_dubbo_consumer.xml"};
        String path = "mysql/spring-mysql.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        IRecommendMetadataService service = context.getBean(IRecommendMetadataService.class);
        String key = "IGuessLikeService";
        RecommendMetadata metadata = service.findByParamKey(key);
        System.out.println(metadata.getParam_value());
        System.out.println("-------------------------------------------------------------------");

        IRecICFService recICFService = context.getBean(IRecICFService.class);
        RecommendItems recommend = recICFService.findByUserId(100001l);
        System.out.println("ICF: " + recommend);
        System.out.println("-------------------------------------------------------------------");

        IRecDirectoryService recDirectory = context.getBean(IRecDirectoryService.class);
        recommend = recDirectory.findByUserId(100935l);
        System.out.println("Directory : " + recommend);

        System.out.println("-------------------------------------------------------------------");
        IRecUserDisService recUserDisService = context.getBean(IRecUserDisService.class);
        recommend = recUserDisService.findByUserId(100001l);
        System.out.println("DIS : " + recommend);

        System.out.println("-------------------------------------------------------------------");
        IRecSimilaryService recSimilaryService = context.getBean(IRecSimilaryService.class);
        recommend = recSimilaryService.findByUserId(100002l);
        System.out.println("SIM : " + recommend);

        System.out.println("-------------------------------------------------------------------");
        IRecLookAgainService recLookAgainService = context.getBean(IRecLookAgainService.class);
        RecommendLookItems recommendLookItem = recLookAgainService.findByIdAndType(395L, 0);
        System.out.println("LookAgain : " + recommendLookItem);

        System.out.println("-------------------------------------------------------------------");
        IRecLookBuyService recLookBuyService = context.getBean(IRecLookBuyService.class);
        recommendLookItem = recLookBuyService.findByIdAndType(29L, 0);
        System.out.println("LookBuy : " + recommendLookItem);

        System.out.println("-------------------------------------------------------------------");
        IRecAgenspuService recAgentspuService = context.getBean(IRecAgenspuService.class);
        recommend = recAgentspuService.findByUserId(100001l);
        System.out.println("Agentspu: " + recommend);
        // System.out.println(metadata.getParam_value());
        System.out.println("-------------------------------------------------------------------");
        IHyipTaskService hyipTaskService = context.getBean(IHyipTaskService.class);
        List<HyipTask> tasks = hyipTaskService.findTasksLessMargins(1000, 10, 1);
        System.out.println("Hyip task : " + tasks.size() + " ," + tasks);
        System.out.println("-------------------------------------------------------------------");
        ITaskActivityService taskActivityService = context.getBean(ITaskActivityService.class);
        List<TaskActivity> taskActivitys = taskActivityService.findTasksLessMargins(1000, 1);
        System.out.println("TaskActivity : " + taskActivitys.size() + ", " + taskActivitys);

        System.out.println("-------------------------------------------------------------------");
        IUserScoreLevelService userScoreLevelService = context.getBean(IUserScoreLevelService.class);
        UserScoreLevel userScoreLevel = userScoreLevelService.findById(100018);
        System.out.println("UserScoreLevel : " + userScoreLevel );
        
        System.out.println("-------------------------------------------------------------------");
        ITweetInfoService tweetinfoService = (ITweetInfoService) context.getBean("tweetInfoServiceImpl");
       
        List<TweetInfo> tweetinfoList = tweetinfoService.getTweetInfoList();
        System.out.println("tweetinfoList : " + tweetinfoList.size() + ", " + tweetinfoList );

        System.out.println("-------------------------------------------------------------------");
         IRecTweetDLService recTweetService = (IRecTweetDLService) context.getBean("recTweetDLServiceImpl");
         RecommendTweetItems recomendItem = recTweetService.findByUserId(0);
        System.out.println("RecTweetDLServiceImpl recomendItem : "+ recomendItem );
        
        System.out.println("-------------------------------------------------------------------");
        tweetinfoService = (ITweetInfoService) context.getBean("tweetPoolServcieImpl");
//
        tweetinfoList = tweetinfoService.getTweetInfoList();
        System.out.println("TweetPoolServcieImpl : " + tweetinfoList.size() + ", " + tweetinfoList );

        System.out.println("-------------------------------------------------------------------");
        recTweetService = (IRecTweetDLService) context.getBean("recTweetTRServiceImpl");
          recomendItem = recTweetService.findByUserId(0);
        System.out.println("RecTweetTRServiceImpl recomendItem : "+ recomendItem );

        System.out.println("-------------------------------------------------------------------");
        IRecShopViewService recShopViewService = context.getBean(IRecShopViewService.class);
        RecommendShop recomendshop = recShopViewService.findByUserId(0);
        System.out.println("IRecShopViewService recomendItem : "+ recomendshop.getShopIds() );
        System.out.println("-------------------------------------------------------------------");
        IRecShopBuyService recShopBuyService = context.getBean(IRecShopBuyService.class);
         recomendshop = recShopBuyService.findByUserId(0);
        System.out.println("IRecShopBuyService recomendItem : "+ recomendshop.getShopIds() );
        System.out.println("-------------------------------------------------------------------");
        IRecShopICFService recShopICFService = context.getBean(IRecShopICFService.class);
         recomendshop = recShopICFService.findByUserId(0);
        System.out.println("IRecShopICFService recomendItem : "+ recomendshop.getShopIds() );
        System.out.println("-------------------------------------------------------------------");
        IRecShopPrdService recShopPrdService = context.getBean(IRecShopPrdService.class);
         recomendshop = recShopPrdService.findByUserId(0);
        System.out.println("IRecShopPrdService recomendItem : "+ recomendshop.getShopIds() );

        System.out.println("-------------------------------------------------------------------");
        IRecGoodProductService recGoodProductService = context.getBean(IRecGoodProductService.class);
        RecGoodProduct recGoodProduct = recGoodProductService.findBySpuId(1248);
        System.out.println("IRecGoodProductService recomendItem : "+ recGoodProduct.getRank() );

        System.out.println("-------------------------------------------------------------------");
        IGRankService iGRankService = context.getBean(IGRankService.class);
        GRank grank = iGRankService.findBySpuId(22);
        System.out.println("IGRankService grank : "+ grank );
        System.out.println("-------------------------------------------------------------------");
        IMerDirectoryService merDirectoryService = context.getBean(IMerDirectoryService.class);
        MerDirectory directory = merDirectoryService.findByDirId("101100100100");
        System.out.println("directory : " + directory.getDirName());
    }
}
