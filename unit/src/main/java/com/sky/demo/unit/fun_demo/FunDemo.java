package com.sky.demo.unit.fun_demo;

import com.google.common.collect.Lists;
import org.mockito.internal.util.collections.Sets;

import java.util.List;
import java.util.Set;

/**
 * Created by rg on 9/18/15.
 */
public class FunDemo {


    public static boolean condition1(int a, int b, int c, int result) {
        return (a + b - c) == result;
    }

    public static boolean condition2(int a, int b, int c, int result) {
        return (a - b * c) == result;
    }

    public static boolean condition3(int a, int b, int c, int result) {
        return (a + b - c) == result;
    }

    public static boolean condition4(int a, int b, int c, int result) {
        return (a + b / c) == result;
    }

    public static boolean condition5(int a, int b, int c, int result) {
        return (a - b * c) == result;
    }

    public static boolean condition6(int a, int b, int c, int result) {
        return (a - b - c) == result;
    }


    public static void main(String[] args) {

        List<List<Integer>> conList = Lists.newArrayList();
        for (int i = 1; i <= 8; ++i) {
            for (int j = 1; j <= 8 ; j++) {
                for (int k = 1; k <= 8 ; k++) {
                    for (int m = 1; m <= 8 ; m++) {
                        Set set = Sets.newSet();
                        set.add(i);
                        set.add(j);
                        set.add(k);
                        set.add(m);

                        if (set.size() == 4 && condition1(i, j, 9, 4) && condition6(9, k, m, 4)) {
                            System.out.println(i + "," + j + "," + k + "," + m);
                            List<Integer> list = Lists.newArrayList();
                            list.add(i);
                            list.add(j);
                            list.add(k);
                            list.add(m);
                            conList.add(list);
                        }
                    }
                }
            }
        }

        System.out.println(conList);
        for (List<Integer> list : conList) {
            for (int i = 1; i <= 8; ++i) {
                for (int j = 1; j <= 8; j++) {
                    for (int k = 1; k <= 8 ; k++) {
                        for (int m = 1; m <= 8; m++) {
                            Set set = Sets.newSet();
                            for (Integer a : list){
                                set.add(a);
                            }
                            set.add(i);
                            set.add(j);
                            set.add(k);
                            set.add(m);
//                            if (set.size() == 8) {
//                                System.out.println(set);
//                            }

                            if (set.size() == 8 && condition2(i, j, list.get(2), 4) && condition3(k, m, list.get(3), 4)
                                    ) {
                                System.out.println(list + ", " + i + "," + j + "," + k + "," + m);
                            }
                        }
                    }
                }


            }


        }




    }


}
