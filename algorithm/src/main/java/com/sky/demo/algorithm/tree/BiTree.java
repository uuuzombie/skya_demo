package com.sky.demo.algorithm.tree;

import com.google.common.base.Objects;

/**
 * Created by user on 17/6/5.
 */
public class BiTree {

    private int value;
    private BiTree left;
    private BiTree right;

    public BiTree() {
    }

    public BiTree(int value) {
        this.value = value;
    }

    public BiTree(int value, BiTree left, BiTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BiTree getLeft() {
        return left;
    }

    public void setLeft(BiTree left) {
        this.left = left;
    }

    public BiTree getRight() {
        return right;
    }

    public void setRight(BiTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("value", value)
                .add("left", left)
                .add("right", right)
                .toString();
    }
}
