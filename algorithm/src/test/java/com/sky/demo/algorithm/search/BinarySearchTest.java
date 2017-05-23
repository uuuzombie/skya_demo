package com.sky.demo.algorithm.search;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by rg on 23/05/2017.
 */
public class BinarySearchTest {

    private int[] array;

    @Before
    public void setUp() {
        array = new int[]{3,5,6,7,8,9,10};
    }


    @Test
    public void test_binarySearch() {

        int value = 10;
        int result = BirnarySearchDemo.binarySearch(array, value);
        System.out.println(result);
    }

}
