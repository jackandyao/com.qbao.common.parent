package com.qbao.recommend.business;

import java.util.List;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.product.cmp.handler.impl.SpuDuplicateHandler;

public class DuplicateDemo {
    public static void main(String[] args) {
        List<Long>list=Lists.newArrayList();
        list.add(Long.valueOf(100));
        list.add(Long.valueOf(100));
        list.add(Long.valueOf(100));
        list.add(Long.valueOf(100));
        list.add(Long.valueOf(999));
        
        new SpuDuplicateHandler().executeHandler(list);
        
        for(Long l:list){
            System.out.println(l);
        }
    }
}
