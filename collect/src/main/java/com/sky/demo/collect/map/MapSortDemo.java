package com.sky.demo.collect.map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * Created by user on 17/5/31.
 */
public class MapSortDemo {


    /**
     * sort by map value size
     * @param input
     * @return
     */
    public static List<Map.Entry<String, List<Integer>>> sortMapByValueSize(Map<String, List<Integer>> input) {
        Preconditions.checkNotNull(input, "input is null");

        //define value comparator
        Comparator<Map.Entry<String, List<Integer>>> comparator = new Comparator<Map.Entry<String, List<Integer>>>() {
            @Override
            public int compare(Map.Entry<String, List<Integer>> o1, Map.Entry<String, List<Integer>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        };

        List<Map.Entry<String, List<Integer>>> list = Lists.newArrayList(input.entrySet());

        Collections.sort(list, comparator);

        return list;
    }


}
