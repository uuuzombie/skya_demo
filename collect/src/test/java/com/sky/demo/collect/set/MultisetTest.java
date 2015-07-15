package com.sky.demo.collect.set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.Random;

/**
 * Created by rg on 2015/6/23.
 */
//Multiset插入无序，但允许重复
public class MultisetTest {

    @Test
    public void test_Multiset_is_order(){

        Multiset<Integer> multiSet = HashMultiset.create();
        Random random = new Random();

        for (int i = 0;i < 10;++i){
            Integer a = random.nextInt(10);
            System.out.println(a);
            multiSet.add(a);
        }
        System.out.println(multiSet);
    }
}
