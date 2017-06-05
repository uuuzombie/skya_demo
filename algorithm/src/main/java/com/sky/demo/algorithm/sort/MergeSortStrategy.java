package com.sky.demo.algorithm.sort;

import com.google.common.base.Preconditions;

/**
 * Created by rg on 4/14/16.
 */
public class MergeSortStrategy extends SortStrategy {

    @Override
    public void sort(int[] array) {
        Preconditions.checkNotNull(array, "array is null!");

        mergeSort(array, 0 , array.length - 1);
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        } else {
            int mid = (high - low) / 2 + low;

            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);

            merge(array, low, mid, high);
        }
    }


    //升序归并，将有序序列a[low..mid]和 a[mid+1..high]归并到a[low..high]
    private void merge(int[] array, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // 归并剩余元素
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }

        for (int t = 0; t < high - low + 1; ++t) {
            array[low + t] = temp[t];
        }
    }
}
