package com.sky.demo.collect.array;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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


    @Test
    public void test_Arrays_asList() {

        List<String> list1 = Arrays.asList(new String[]{"a", "b"});
        System.out.println(list1);

        List<String> list2 = new ArrayList<String>();
        System.out.println(list2);

    }

    @Test
    public void test_Arrays_asList_remove() {

        //使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
        //说明：asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适配器模式，只是转换接口，后台的数据仍是数组。
//        Arrays.asList(new String[]{"a", "b"}).remove(0);  //java.lang.UnsupportedOperationException

//        List<String> list = Arrays.asList(new String[]{"a", "b"});
        List<String> list = Lists.newArrayList("1", "2");

        System.out.println(list);
        list.remove(0);
        System.out.println(list);


    }

}
