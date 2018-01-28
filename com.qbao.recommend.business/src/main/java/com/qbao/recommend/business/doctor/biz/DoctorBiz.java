/**
 * 
 */
package com.qbao.recommend.business.doctor.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.QbdcKeywordDeptReal;
import com.qbao.recommend.respositoy.mysql.service.IDoctorDataService;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
@Component
public class DoctorBiz implements IDoctorBiz {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    IDoctorDataService doctorDataService;

    @Override
    public List<Long> fetchRecommend(String desc) {
        List<Long> result = new ArrayList<Long>();
        List<Word> words = WordSegmenter.seg(desc, SegmentationAlgorithm.BidirectionalMaximumMinimumMatching);
        List<QbdcKeywordDeptReal> keyWordList = doctorDataService.getAllDeptIdAndKeywords();
        for (Word word : words) {
            for (QbdcKeywordDeptReal keyword : keyWordList) {
                logger.info("word : " + word.toString());
                logger.info("key word: " + keyword.getKeyWord());
                Pattern pattern = Pattern.compile("^.*" + word.toString() + ".*");
                Matcher matcher = pattern.matcher(keyword.getKeyWord());
                boolean b = matcher.matches();
                if (b) {
                    result.add(keyword.getDeptId());
                }
            }

        }
        return result;
    }

    @Override
    public void updateDiseaseDescription() {
        // TODO Auto-generated method stub

    }

}
