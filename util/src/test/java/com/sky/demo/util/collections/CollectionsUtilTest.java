package com.sky.demo.util.collections;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by rg on 15/7/5.
 */
public class CollectionsUtilTest {

    private Integer[] array = new Integer[10];
    private Map<String,Integer> map = Maps.newHashMap();

    @Before
    public void setUp(){
        Random random = new Random(1000);
        for (int i = 0;i < 10;++i){
            array[i] = random.nextInt();
        }

        for (int i = 0;i < 10;++i){
            map.put("Test" + i,i);
        }
    }

    @Test
    public void test_arraySort(){

        for (int i = 0;i < array.length;++i){
            System.out.println(array[i]);
        }
        System.out.println("***********");

        CollectionsUtil.arraySort(array);
        for (int i = 0;i < array.length;++i){
            System.out.println(array[i]);
        }
    }

    @Test
    public void test_getPreN(){
        List<String> list = CollectionsUtil.getPreN(map,15);  //10 ，5
        System.out.println(list);
    }
}
