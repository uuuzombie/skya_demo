package com.sky.demo.unit.package_post;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 17/5/31.
 */
public class PackagePostTest {


    private Map<String, List<Integer>> cabinsWithProducts;


    @Before
    public void setUp() {
        cabinsWithProducts = Maps.newHashMap();

        cabinsWithProducts.put("A", Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8));
        cabinsWithProducts.put("B", Lists.newArrayList(9));
        cabinsWithProducts.put("C", Lists.newArrayList(1, 3, 5, 7, 8, 9));
        cabinsWithProducts.put("D", Lists.newArrayList(2, 4, 6, 8, 10));
        cabinsWithProducts.put("E", Lists.newArrayList(2, 3, 4, 5, 8));
        cabinsWithProducts.put("F", Lists.newArrayList(1, 2, 3, 4));
        cabinsWithProducts.put("G", Lists.newArrayList(1, 5, 6, 7, 8, 9));
        cabinsWithProducts.put("H", Lists.newArrayList(1, 2, 3, 4, 5, 8, 10));
        cabinsWithProducts.put("I", Lists.newArrayList(6, 7, 8));
        cabinsWithProducts.put("J", Lists.newArrayList(10));


    }


    @Test
    public void test_splitOrder() {
        Map<String, List<Integer>> result = Maps.newHashMap();

        PackagePost.splitOrder(cabinsWithProducts, result);
        System.out.println(result);

    }
}
