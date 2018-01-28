package com.qbao.recommend.business.userfroit.rest;

import java.util.Map;

public interface IUserFroitService {

	Map<String,Object> getUserFroit(long userId, long joinFee,int days);
}
