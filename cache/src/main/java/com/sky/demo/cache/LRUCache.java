package com.sky.demo.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rg on 2015/7/15.
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int maxElements;

    public LRUCache(int maxSize) {
        //accessOrder，它表示：
        //1）false，所有的Entry按照插入的顺序排列
        //2）true，所有的Entry按照访问的顺序排列（"访问"，这个词有两层意思：1、根据Key拿到Value，也就是get方法2、修改Key对应的Value，也就是put方法）
        super(maxSize, 075F, true);
        this.maxElements = maxSize;
    }

    //重写LinkedHashMap的removeEldestEntry()固定table中链表的长度
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxElements;  //default return false;
    }
}

