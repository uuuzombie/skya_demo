package com.sky.demo.util.collections;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by rg on 15/7/5.
 */
public class CollectionsUtil {
    //数组排序，Arrays类， （Java命名规则，+s），排序用 Arrays中 sort
    //工具类没有状态，当作工具用，提供的方法为静态，工具类的书写注意命名、状态（Static）、不被继承（构造函数私有化）

    /**
     * 数组排序
     * @param array
     */
    public static void arraySort(Integer[] array){
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);   //考虑溢出情况？
            }
        });
    }


    /**
     * 获取前n个出现最多的，如果n大于map.size()，则输出所有，降序
     * @param map
     * @param n
     * @return
     */
    public static List<String> getPreN(Map<String,Integer> map,Integer n){
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());  //map中Entry存入List中

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() { //调用工具类Collections.sort()方法，并重载Comparator<T>
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //return ( o1.getValue() - o2.getValue());		//升序排列
                return (o2.getValue() - o1.getValue());        //降序排列
            }
        });

        List<String> resultList = Lists.newArrayList();
        int size = map.size() >= n ? n : map.size();
        for (int i = 0;i < size;++i){
            resultList.add(list.get(i).getKey());
        }
        return resultList;
    }
}
