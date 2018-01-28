package com.qbao.recommend.business.product.cmp.strategy;

import java.util.List;

public interface IDataCompletionStrategy {
    public void executeDataCompletion(List<Long>oldList,int num);
}
