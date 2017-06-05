package com.sky.demo.algorithm.search;

import com.google.common.base.Preconditions;

/**
 * Created by rg on 23/05/2017.
 * 二分查找算法，输入的数组是有序的，升序
 */
public class BinarySearchDemo {

    //非递归
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


    //递归
    public static int binarySearchRecursion(int[] array, int low, int high, int value) {
        Preconditions.checkNotNull(array, "array is null");

        int result = -1;
        if (low > high) {
            return result;
        }

        int mid = (high - low) / 2 + low;

        if (array[mid] == value) {
            result = mid;
        } else if (array[mid] > value) {
            result = binarySearchRecursion(array, low, mid - 1, value);
        } else if (array[mid] < value) {
            result = binarySearchRecursion(array, mid + 1, high, value);
        }
        return result;
    }


}
