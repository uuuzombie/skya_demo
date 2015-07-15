package com.sky.demo.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rg on 2015/7/15.
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int cacheSize;

    public LRUCache(int initialCapacity, float loadFactor, int cacheSize) {
        super(initialCapacity, loadFactor, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
}

