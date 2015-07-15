package com.sky.demo.collections.array;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void test_List_to_Array() {
        List<Object> list = Lists.newArrayList();
        list.add("10");
        list.add(20);

        Object[] params = new Object[]{list};   //list作为数组中第一个元素
        System.out.println( params.length);     // =1
        for (Object o : params) {
            System.out.println(o);
        }

        params = list.toArray();        //List已有转数组的方法
        System.out.println(params.length);
    }

}
