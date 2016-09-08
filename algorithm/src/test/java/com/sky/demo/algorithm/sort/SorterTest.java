package com.sky.demo.algorithm.sort;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rg on 4/18/16.
 */
public class SorterTest {

    private List<int[]> arrayList = Lists.newArrayList();

    @Before
    public void setUp() {
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] array2 = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        int[] array3 = new int[]{3, 2, 6, 1, 8, 2, 4, 9};
        int[] array4 = new int[]{2, 2, 6, 1, 1, 2, 4, 9};
        int[] array5 = new int[]{3, 2, 6, 1, 8, 2, 4, 9};

        arrayList.add(array1);
        arrayList.add(array2);
        arrayList.add(array3);
        arrayList.add(array4);
        arrayList.add(array5);


    }

    @Test
    public void test_sort_Binary() {
        SortStrategy sortStrategy = new BinarySortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        for (int[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("===============");
        for (int[] array : arrayList) {
            sorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    @Test
     public void test_sort_Bubble() {
        SortStrategy sortStrategy = new BubbleSortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        for (int[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("===============");
        for (int[] array : arrayList) {
            sorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    @Test
    public void test_sort_Heap() {
        SortStrategy sortStrategy = new HeapSortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        for (int[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("===============");
        for (int[] array : arrayList) {
            sorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    @Test
    public void test_sort_Insertion() {
        SortStrategy sortStrategy = new InsertionSortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        for (int[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("===============");
        for (int[] array : arrayList) {
            sorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    @Test
    public void test_sort_Merge() {
        SortStrategy sortStrategy = new MergeSortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        for (int[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("===============");
        for (int[] array : arrayList) {
            sorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    @Test
    public void test_sort_Quick() {
        SortStrategy sortStrategy = new QuickSortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        for (int[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("===============");
        for (int[] array : arrayList) {
            sorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    @Test
    public void test_sort_Radix() {
        SortStrategy sortStrategy = new RadixSortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        for (int[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("===============");
        for (int[] array : arrayList) {
            sorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    @Test
    public void test_sort_Selection() {
        SortStrategy sortStrategy = new SelectionSortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        for (int[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("===============");
        for (int[] array : arrayList) {
            sorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    @Test
    public void test_sort_Shell() {
        SortStrategy sortStrategy = new ShellSortStrategy();
        Sorter sorter = new Sorter(sortStrategy);

        for (int[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("===============");
        for (int[] array : arrayList) {
            sorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

}
