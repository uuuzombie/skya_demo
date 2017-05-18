package com.sky.demo.algorithm.topic;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 17/5/18.
 */
//@RunWith(Parameterized.class)
public class FindMinProductTest {


//    private int[] array;
//    private int[] expect;
//
//    public FindMinProductTest(int[] array, int[] expect) {
//        this.array = array;
//        this.expect = expect;
//    }

//    @Parameterized.Parameters
//    public static Collection<Integer[][]> prepareData() {
//        return Arrays.asList(new Integer[][][]{
////                {},
////                {0},
//                {{0, 1}, {0}},
//                {{-1, 1},{-1}},
//                {{0, 1, 2},{0}},
//                {{-1, 1, 2},{-2}},
//                {{-10, -2, 1},{-10}},
//                {{-10, -2, -1},{-20}},
//                {{-10, -3, -2, 1},{-60}}
//        });
//    }

//    @Test
//    public void test_find() {
//
//        long result = FindMinProduct.findMinPro(array);
//        assertEquals(expect[0], result);
//
//    }

    @Test
    public void test_find() {

        int[][] arrays = new int[][] {
                {},
                {0},
                {1},
                {0,1},
                {0,1,2},

                {-2,1},
                {-2,1,2},
                {-2,0,2},
                {-2,0},
                {-2},

                {-10,-2},
                {-10,-2,0},
                {-10,-2,0,0},
                {-10,-2,0,2},
                {-10,-2,2,2},

                {-10,-2,-2},
                {-10,-2,-2,0},
                {-10,-2,-2,3},
                {-10,-2,-2,3,0,0},

                {-10,-2,-2,-2},
                {-10,-2,-2,-2,0},
                {-10,-2,-2,-2,3},
                {-10,-2,-2,-2,3,0,0},
        };
//        int[] array = new int[]{};
//        int[] array = new int[]{1};
//        int[] array = new int[]{0,1};
//        int[] array = new int[]{-1,1};
//        int[] array = new int[]{0,1,2};
//        int[] array = new int[]{-1,1,2};
//        int[] array = new int[]{-10,-2,2};
//        int[] array = new int[]{-10,-2,-2};
//        int[] array = new int[]{-10,-2,-2,-2};
//        int[] array = new int[]{-10,-2,0,0};


        for (int i = 0;i < arrays.length; i++) {
            long result = FindMinProduct.findMinPro(arrays[i]);


            System.out.println(Arrays.toString(arrays[i]) + " -> " + result);
        }
    }


}
