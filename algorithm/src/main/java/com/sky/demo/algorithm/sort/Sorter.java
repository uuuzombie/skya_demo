package com.sky.demo.algorithm.sort;

/**
 * Created by rg on 4/14/16.
 * 环境角色
 */
public class Sorter {

    private SortStrategy sortStrategy;      //Strategy class

    //Construct method
    public Sorter(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }


    public SortStrategy getSortStrategy() {
        return sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }


    //Strategy method
    public void sort(int[] array) {
        sortStrategy.sort(array);
    }
}
