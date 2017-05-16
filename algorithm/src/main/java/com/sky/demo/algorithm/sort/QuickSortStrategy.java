package com.sky.demo.algorithm.sort;

import com.google.common.base.Preconditions;


/**
 * Created by rg on 4/14/16.
 * 快速排序是不稳定的。
 * 最理想情况算法时间复杂度O(nlog2n)，最坏O(n^2)。
 * 空间复杂度O(log2n)。
 */
public class QuickSortStrategy extends SortStrategy {

    @Override
    public void sort(int[] array) {
        Preconditions.checkNotNull(array, "array is null");

        quickSort(array, 0, array.length - 1);
    }


    private void quickSort(int[] array, int low, int high) {

        if (low >= high) {
            return;
        } else {
            int index = partition(array, low, high);

            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }

    }

    // 快速排序法的划分操作
    private int partition(int[] array, int low, int high) {
        int pivot = array[low];

        while (low < high) {

            while (low < high && array[high] >= pivot) {
                high--;
            }
            array[low] = array[high];

            while (low < high && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }

        // 此时low==high
        array[low] = pivot;
        return low;
    }
}
