package com.sky.demo.algorithm.tree;

import com.google.common.base.Objects;

import java.util.Set;

/**
 * Created by user on 17/6/5.
 */
public class MultiTree {

    private int value;
    private Set<MultiTree> subNodes;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<MultiTree> getSubNodes() {
        return subNodes;
    }

    public void setSubNodes(Set<MultiTree> subNodes) {
        this.subNodes = subNodes;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("value", value)
                .add("subNodes", subNodes)
                .toString();
    }
}
