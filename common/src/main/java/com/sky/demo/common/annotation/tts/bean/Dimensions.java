package com.sky.demo.common.annotation.tts.bean;

import com.google.common.base.Objects;
import com.sky.demo.common.annotation.tts.type.ActionType;
import com.sky.demo.common.annotation.tts.type.PassengerType;
import com.sky.demo.common.annotation.tts.type.PolicyType;

/**
 * Created by rg on 15/6/27.
 */
public class Dimensions {

    private PolicyType policyType;

    private PassengerType passengerType;

    private ActionType actionType;

    public PolicyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("policyType", policyType)
                .add("passengerType", passengerType)
                .add("actionType", actionType)
                .toString();
    }
}
