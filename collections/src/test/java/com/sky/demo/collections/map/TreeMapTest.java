package com.sky.demo.collections.map;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * Created by rg on 2015/6/23.
 */
public class TreeMapTest {

    Map<String,Integer> map = Maps.newTreeMap();

    @Before
    public void setUp(){
        map.put("c", 0);
        map.put("d", 3);
        map.put("a", 1);
        map.put("e", 1);
        map.put("f", 1);
        map.put("c", 1);        //TreeMap 会将重复key的value 覆盖
        map.put("h", 1);

    }

    @Test
    public void test_TreeMap(){

        Set<Map.Entry<String,Integer>> set = map.entrySet();
        for (Map.Entry<String,Integer> element : set) {
            System.out.println(element.getKey() + ":" + element.getValue());
        }
    }

    @Test
    public void test_TreeMap_keySet(){

        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s);
        }
    }

}
