package com.sky.demo.io.count_character.action;

import com.google.common.collect.Maps;
import com.sky.demo.io.count_character.service.CharCounter;

import java.util.Map;

/**
 * Created by rg on 15/6/27.
 */
public class LetterCharCounter implements CharCounter {

    int total = 0;
    Map<Character,Integer> result = Maps.newHashMap();

    @Override
    public void count(char c) {
        //TODO 正则匹配
        if (Character.isLetter(c)) {
            Integer current_count = result.get(c);
            if (current_count == null) {
                result.put(c,1);
            } else {
                result.put(c,current_count + 1);
            }
        }
    }

    @Override
    public Map<String, Integer> getSummary() {
        Map<String,Integer> summary = Maps.newHashMap();
        summary.put("字母",total);
        return summary;
    }

    @Override
    public Map<String, Integer> getDetail() {
        Map<String,Integer> detail = Maps.newTreeMap();
        for (Map.Entry<Character,Integer> entry : result.entrySet()) {
            detail.put("字母" + entry.getKey(),entry.getValue());
        }
        return detail;
    }
}
