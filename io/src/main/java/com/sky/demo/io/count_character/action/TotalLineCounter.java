package com.sky.demo.io.count_character.action;

import com.google.common.collect.Maps;
import com.sky.demo.io.count_character.service.LineCounter;

import java.util.Map;

/**
 * Created by rg on 15/6/27.
 */
public class TotalLineCounter implements LineCounter {

    int total = 0;

    @Override
    public void count(String line) {
        total++;
    }

    @Override
    public Map<String, Integer> getSummary() {
        Map<String,Integer> result = Maps.newHashMap();
        result.put("行数", total);
        return result;
    }

    @Override
    public Map<String, Integer> getDetail() {
        return null;
    }
}
