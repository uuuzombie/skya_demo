package com.sky.demo.io.count_character.service;

import java.util.Map;

/**
 * Created by rg on 15/6/27.
 */
public interface Reportable {

    public Map<String,Integer> getSummary();

    public Map<String,Integer> getDetail();
}
