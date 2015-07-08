package com.sky.demo.collect.array;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rg on 2015/6/23.
 */
public class ArrayTest {

    @Test
    public void test_Array(){

        Integer[] array = new Integer[]{0,1,2};

        for(int i = 0 , length = array.length;i < length;++i){
            System.out.println(array[i]);
        }

        //Java 5 以后加入语法糖，foreach，代码更简洁，更安全
        for(int element : array){
            System.out.println(element);
        }
    }

    @Test
    public void test_string_array(){
        String str = "";
        String[] arrays = str.split(",");

        if(arrays == null) {
            System.out.println("array is null");
        }

    }
}
