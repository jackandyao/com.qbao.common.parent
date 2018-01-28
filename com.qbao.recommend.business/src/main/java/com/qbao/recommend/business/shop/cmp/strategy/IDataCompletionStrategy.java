package com.qbao.recommend.business.shop.cmp.strategy;

import java.util.List;

public interface IDataCompletionStrategy {
    public void executeDataCompletion(List<String>oldList,int num);
}
