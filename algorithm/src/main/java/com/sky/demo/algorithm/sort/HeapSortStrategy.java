package com.sky.demo.algorithm.sort;

import com.google.common.base.Preconditions;

/**
 * Created by rg on 4/14/16.
 */
public class HeapSortStrategy extends SortStrategy {

    @Override
    public void sort(int[] array) {
        Preconditions.checkNotNull(array, "array is null");

        int length = array.length;

        //创建初始堆
        for (int i = length / 2 - 1; i >= 0; --i) {
            buildHeap(array, i, length);
        }


        for (int i = length - 1; i > 0; --i) {

            //交换堆顶和最后一个元素
            swap(array, 0, i);

            //重新调整堆
            buildHeap(array, 0, i);

        }

    }


    //堆
    private void buildHeap(int[] array, int i, int lastIndex) {

        int nChild = 0;
        while ((2 * i + 1) < lastIndex) {
            //如果存在右子结点，且左子节点 <右子节点，则子结点的位置 =2*（父结点位置）+ 2
            //否则子结点的位置=2*（父结点位置） + 1
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
                //比较左右孩子均小于父节点，则堆未破坏 ,不再需要调整
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
