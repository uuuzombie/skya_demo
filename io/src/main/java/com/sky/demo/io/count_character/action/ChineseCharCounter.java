package com.sky.demo.io.count_character.action;

import com.google.common.collect.Maps;
import com.sky.demo.io.count_character.service.CharCounter;

import java.util.Map;

/**
 * Created by rg on 15/6/27.
 */
public class ChineseCharCounter implements CharCounter {

    int total = 0;

    @Override
    public void count(char c) {
        //TODO 正则匹配
    }

    @Override
    public Map<String, Integer> getSummary() {
        Map<String,Integer> summary = Maps.newHashMap();
        summary.put("汉字",total);
        return summary;
    }

    @Override
    public Map<String, Integer> getDetail() {
        return null;
    }
}
