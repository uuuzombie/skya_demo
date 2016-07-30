package com.sky.demo.algorithm.sort;

import java.util.List;

/**
 * Created by rg on 4/14/16.
 * 抽象策略角色
 */
public abstract class SortStrategy {

    //Strategy method
    public abstract void sort(List<Integer> list);
}
