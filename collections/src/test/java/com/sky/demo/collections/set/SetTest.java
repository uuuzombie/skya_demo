package com.sky.demo.collections.set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Random;
import java.util.Set;

/**
 * Created by rg on 2015/6/23.
 */
//Set 插入无序，且不允许重复
public class SetTest {

    @Test
    public void test_Set_is_order() {

        Set<Integer> set = Sets.newHashSet();
        Random random = new Random();
//        int max = 20;
//        int min = 10;
//        int s = random.nextInt(max) % (max - min + 1) + min;     //随机生成在[min,max]之间的随机整数

        for (int i = 0; i < 10; ++i) {
            Integer integer = random.nextInt(10);
            System.out.println(integer);
            set.add(integer);
        }
        System.out.println(set);
    }
}
