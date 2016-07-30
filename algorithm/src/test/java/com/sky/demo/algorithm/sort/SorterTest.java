package com.sky.demo.algorithm.sort;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by rg on 4/18/16.
 */
public class SorterTest {

    @Test
    public void test_sort_binary() {
        SortStrategy sortStrategy = new BinarySortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        List<Integer> list = Lists.newArrayList(3, 2, 6, 1, 8, 2, 4, 9);
        System.out.println(list);

        sorter.sort(list);
        System.out.println(list);
    }
}
