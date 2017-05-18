package com.sky.demo.cache;

import com.google.common.collect.Maps;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by user on 17/5/18.
 */
public class LRUCacheSafe<K, V> {


    private int maxElement;
    private Map<K, V> cache;

    private ReadWriteLock lock = new ReentrantReadWriteLock();  //


    public LRUCacheSafe(int maxSize) {
        cache = new LinkedHashMap(maxSize, 0.75F, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxElement;
            }
        };

        this.maxElement = maxSize;
    }


    public void put(K key, V value) {
        lock.writeLock().lock();
        try {
            cache.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public V get(K key) {
        lock.readLock().lock();
        V value = null;
        try {
            value = cache.get(key);
        } finally {
            lock.readLock().unlock();
        }
        return value;
    }

    public boolean isContains(K key) {
        lock.readLock().lock();

        boolean isContain = false;
        try {
            isContain = cache.containsKey(key);
        } finally {
            lock.readLock().unlock();
        }
        return isContain;
    }

    public void remove(K key) {
        lock.writeLock().lock();
        try {
            cache.remove(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
