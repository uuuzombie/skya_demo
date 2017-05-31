package com.sky.demo.collect;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
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

        //在一个foreach循环中，编译器会使next()在删除元素之后被调用，因此就会抛出ConcurrentModificationException异常
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

        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e", "f");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }

    }

    @Test(expected = Exception.class)
    public void test_Iterator_next_multi(){

        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(iterator.next());
        }

    }

    @Test(expected = ConcurrentModificationException.class)
    public void test_Iterator_remove(){

        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e", "f");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            list.remove(iterator.next());  // next()必须在remove()之前调用。

//            String str = iterator.next();
//            list.remove(str);
        }

    }
}
