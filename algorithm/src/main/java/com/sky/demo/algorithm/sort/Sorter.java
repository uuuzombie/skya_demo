package com.sky.demo.algorithm.sort;

import java.util.List;

/**
 * Created by rg on 4/14/16.
 * 环境角色
 */
public class Sorter {

    private SortStrategy sortStrategy;      //Strategy class

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
    public void sort(List<Integer> list) {
        sortStrategy.sort(list);
    }
}
