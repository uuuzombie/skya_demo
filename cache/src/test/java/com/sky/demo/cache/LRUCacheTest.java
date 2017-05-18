package com.sky.demo.cache;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by rg on 4/14/16.
 */
public class LRUCacheTest {

    private LRUCache<String, String> cache = new LRUCache<>(10);


    @Before
    public void setUp() {

        for (int i = 1; i <= 5; i++) {
            cache.put(String.valueOf(i), String.valueOf(i));
        }


    }

    @Test
    public void test_add_less_than_maxSize() {

        for (int i = 11; i <= 13; i++) {
            cache.put(String.valueOf(i), String.valueOf(i));
        }

        System.out.println(cache);
    }

    @Test
    public void test_add_more_than_maxSize() {

        for (int i = 11; i <= 18; i++) {
            cache.put(String.valueOf(i), String.valueOf(i));
        }

        System.out.println(cache);
    }

    @Test
    public void test_put() {
        System.out.println(cache);

        cache.put("1", "11");

        System.out.println(cache);

    }

    @Test
    public void test_get() {
        System.out.println(cache);

        cache.get("1");

        System.out.println(cache);
    }
}
