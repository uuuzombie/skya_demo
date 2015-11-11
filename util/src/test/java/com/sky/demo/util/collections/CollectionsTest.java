package com.sky.demo.util.collections;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by rg on 2015/10/15.
 */
public class CollectionsTest {


    @Test
    public void test_sort() {
        List<String> list = Lists.newArrayList("B", "DA", "A", "D");

        Collections.sort(list);
        System.out.println(list);

    }
    
}
