package com.sky.demo.algorithm.search;

import com.google.common.base.Preconditions;

/**
 * Created by rg on 23/05/2017.
 */
public class BirnarySearchDemo {


    public static int binarySearch(int[] array, int value) {
        Preconditions.checkNotNull(array, "array is null");

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int mid = (high - low) / 2 + low;   // 直接使用(high + low) / 2 可能导致溢出
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
