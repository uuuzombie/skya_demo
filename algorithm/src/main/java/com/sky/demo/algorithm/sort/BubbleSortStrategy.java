package com.sky.demo.algorithm.sort;

import com.google.common.base.Preconditions;

/**
 * Created by rg on 4/14/16.
 */
public class BubbleSortStrategy extends SortStrategy {

    @Override
    public void sort(int[] array) {
        Preconditions.checkNotNull(array, "array is null!");

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    Integer temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
