package com.qbao.recommend.business.baoyue.cmp.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Timer;

import javax.annotation.PostConstruct;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.baoyue.cmp.cache.BaoyueCache;
import com.qbao.recommend.business.baoyue.cmp.service.IBaoyueValicateService;
import com.qbao.recommend.respositoy.mysql.model.BYKeyword;
import com.qbao.recommend.respositoy.mysql.service.IBYKeywordService;
import com.qbao.recommend.respositoy.mysql.service.IYouPiaoService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

@Service
public class BaoyueValicateServiceImpl implements IBaoyueValicateService {
	
	@Autowired
	IBYKeywordService bykeywordService;
	
	@Autowired
	IYouPiaoService youPiaoService;
	
	private Logger infoLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_yue, Level.INFO);
	private Logger errorLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_yue, Level.ERROR);
	private Timer timer;
	
	@PostConstruct
	public void startTimer(){
		timer = new Timer(true);
		timer.schedule(
		new java.util.TimerTask() { 
			public void run(){
				infoLogger.info("执行推文关键字定时器任务！");
				try{
					init();
				}catch(Exception e){
					errorLogger.info(e,e);
				}
			}

		}, 0, 24*60*60*1000);
	}

	@Override
	public boolean validation(String line) {
		
		List<Word> tokens = tokenize(line);
		for(Word word : tokens){
			String text = word.getText();
			String topicNum = BaoyueCache.topic.get(text);
			if(topicNum!=null){
				return true;
			}
		}
		return false;
	}

	private static List<Word> tokenize(String line) {
		List<Word> tokens = Lists.newArrayList();
		List<Word> words = WordSegmenter.segWithStopWords(line);
//		PartOfSpeechTagging.process(words);
		for (Word word : words) {
//			if (word.getPartOfSpeech().getPos().contains("n") /*&&word.getText().length() > 1*/)
			if(word.getText().length() > 1)
				tokens.add(word);
		}
		return tokens;
	}
	
	private void init() {
		try {
			readKwFromFile();
		} catch (IOException e) {
			errorLogger.info(e,e);
		}
		readKwFromDB();
		readYouPiaoKw();
		readKuYaKw();
	}
	
	private void readYouPiaoKw() {
		List<String> filmNameList = youPiaoService.findAllFilmName();
		for(String fileName : filmNameList){
			List<Word> list = tokenize(fileName);
			for(Word word : list){
				BaoyueCache.topic.put(word.getText(), "1");
			}
		}
		List<String> titleList = youPiaoService.findAllShowTitle();
		for(String title : titleList){
			List<Word> list = tokenize(title);
			for(Word word : list){
				BaoyueCache.topic.put(word.getText(), "1");
			}
		}
	}

	private void readKwFromDB() {
		List<BYKeyword> list = bykeywordService.findAll();
		for (BYKeyword byKeyword : list) {
			BaoyueCache.topic.put(byKeyword.getKeyword(),byKeyword.getCode());
		}
	}

	private void readKwFromFile() throws IOException{
		FileInputStream f = new FileInputStream("wordset/topic.txt"); 
		BufferedReader dr=new BufferedReader(new InputStreamReader(f));
		String line = null;
		while( (line = dr.readLine()) != null){
			System.out.println(line);
			String[] topicItem = line.split("\\s+");
			if(topicItem.length<2) continue;
			List<Word> words = tokenize(topicItem[0]);
			for(Word word : words) BaoyueCache.topic.put(word.getText(), topicItem[1]);
		}
		dr.close();
	}
	
	private void readKuYaKw() {
		// TODO Auto-generated method stub
		
	}
}
