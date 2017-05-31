package com.sky.demo.collect.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 17/5/31.
 */
public class MapSortDemoTest {

    private Map<String, List<Integer>> map;


    @Before
    public void setUp() {
        map = Maps.newHashMap();

        List<Integer> list1 = Lists.newArrayList();
        List<Integer> list2 = Lists.newArrayList(1,3,5);
        List<Integer> list3 = Lists.newArrayList(2);

        map.put("a", list1);
        map.put("b", list2);
        map.put("c", list3);



    }

    @Test
    public void test_sortMap() {

        System.out.println(map);

        List<Map.Entry<String, List<Integer>>> list = MapSortDemo.sortMapByValueSize(map);

        System.out.println(list);

    }


}
