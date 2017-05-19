package com.sky.demo.algorithm.sort;

import com.google.common.base.Preconditions;

/**
 * Created by rg on 4/14/16.
 * 堆排序是不稳定的。
 * 算法时间复杂度O(nlog2n)。
 * 空间复杂度O(1)。
 */
public class HeapSortStrategy extends SortStrategy {

    @Override
    public void sort(int[] array) {
        Preconditions.checkNotNull(array, "array is null");

        int n = array.length;

        //创建初始堆，需要从中间开始调整，需要n/2 - 1 趟
        //结果：调整成大根堆（父节点比左右子节点大），array[0]堆顶为最大值
        for (int i = n / 2 - 1; i >= 0; --i) {
            heapAdjust(array, i, n);
        }


        for (int i = n - 1; i > 0; --i) {
            //交换堆顶array[0]和最后一个元素array[i]
            swap(array, 0, i);

            //重新调整堆，每次循环仅需调整一趟
            heapAdjust(array, 0, i);
        }
    }


    //调整堆，将最大值调整到堆顶 array[0]
    private void heapAdjust(int[] array, int i, int lastIndex) {

        int nChild = 0;
        while ((2 * i + 1) < lastIndex) {
            //找出较大的子结点
            if ((2 * i + 2) < lastIndex && array[2 * i + 1] < array[2 * i + 2]) {
                nChild = 2 * i + 2;
            } else {
                nChild = 2 * i + 1;
            }

            //如果较大的子结点大于父结点 ,则交换
            if (array[i] < array[nChild]) {
                swap(array, i, nChild);

                i = nChild;     //交换之后i变为交换后的子节点 nChild，继续调整
            } else {
                //比较左右子节点均小于父节点，则堆未破坏 ,不再需要调整
                break;
            }

        }

    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
