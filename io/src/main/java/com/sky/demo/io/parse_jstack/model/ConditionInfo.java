package com.sky.demo.io.parse_jstack.model;

import com.google.common.base.Objects;

/**
 * Created by rg on 15/6/28.
 */
public class ConditionInfo {

    private String conditionId;
    private Integer count;

    public ConditionInfo() {
    }

    public ConditionInfo(String conditionId, Integer count) {
        this.conditionId = conditionId;
        this.count = count;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("conditionId", conditionId)
                .add("count", count)
                .toString();
    }
}
