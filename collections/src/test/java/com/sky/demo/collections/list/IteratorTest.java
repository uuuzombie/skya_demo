package com.sky.demo.collections.list;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rg on 2015/6/23.
 */
public class IteratorTest {

    List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

    @Test(expected = Exception.class)
    public void test_foreach(){
        //采用foreach方法会抛异常
        System.out.println(list);
        int i = 0;
        for (Integer integer : list) {
            if (i % 2 == 0) {
                list.remove(i);
            }
            i++;
        }
        System.out.println(list);
    }

    @Test
    public void test_Iterator(){

        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    @Test
    public void test_Iterator_next(){

        List<String> list = Arrays.asList("a", "b", "c");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }

    }
}
