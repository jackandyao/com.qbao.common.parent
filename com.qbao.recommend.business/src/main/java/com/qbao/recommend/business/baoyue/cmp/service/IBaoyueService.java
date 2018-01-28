package com.qbao.recommend.business.baoyue.cmp.service;

import com.qbao.recommend.business.baoyue.rest.dto.BaoYueDto;
import com.qbao.recommend.respositoy.restful.entities.User;

import java.util.List;

public interface IBaoyueService {

	 List<BaoYueDto> filter(List<User> users, long categoryId);
	 
	 List<BaoYueDto> filter(List<User> users, long categoryId, int limit);
	 
}
