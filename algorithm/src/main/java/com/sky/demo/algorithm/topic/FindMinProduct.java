package com.sky.demo.algorithm.topic;

import com.google.common.base.Preconditions;

import java.util.Arrays;

/**
 * Created by user on 17/5/18.
 * 求数组最小乘积
 */
public class FindMinProduct {


    public static long findMinPro(int[] array) {
        Preconditions.checkNotNull(array, "array is null");
        long result = 0;

        if (array.length == 0) {
            return result;
        } else if (array.length == 1) {
            return array[0];
        }

        Arrays.sort(array);     //sort

        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;
        int maxNegative = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                negativeCount++;

                if (array[i] > maxNegative) {
                    maxNegative = array[i];
                }
            } else if (array[i] > 0) {
                positiveCount++;
            } else if (array[i] == 0) {
                zeroCount++;
            }
        }


        if (negativeCount > 2 ) {

            int temp = 1;
            for (int i = 0; i < array.length; ++i) {
                if (array[i] != 0) {
                    temp *= array[i];
                }
            }

            if (negativeCount % 2 == 1) {
                result = temp;
            } else {
                result = temp / maxNegative;
            }

        } else if (negativeCount == 2) {
            if (positiveCount == 0) {
                if (zeroCount > 0) {
                    result = 0;
                } else {
                    result = array[0] * array[1];
                }
            } else {

                int temp = 1;
                for (int i = 0; i < array.length; ++i) {
                    if (array[i] != 0) {
                        temp *= array[i];
                    }
                }

                if (negativeCount % 2 == 1) {
                    result = temp;
                } else {
                    result = temp / maxNegative;
                }

            }

        } else if (negativeCount == 1) {
            if (positiveCount == 0) {
                result = 0;
            } else {

                int temp = 1;
                for (int i = 0; i < array.length; ++i) {
                    if (array[i] != 0) {
                        temp *= array[i];
                    }
                }

                if (negativeCount % 2 == 1) {
                    result = temp;
                } else {
                    result = temp / maxNegative;
                }

            }


        } else if (negativeCount == 0) {
            if (positiveCount == 0) {
                result = 0;
            } else {
                result = array[0] * array[1];
            }
        }

        return result;
    }


}
