package com.sky.demo.common.annotation.tts.service;

import com.google.common.collect.Lists;
import com.sky.demo.common.annotation.tts.anno.TTS;
import com.sky.demo.common.annotation.tts.bean.Dimensions;
import com.sky.demo.common.annotation.tts.type.ActionType;
import com.sky.demo.common.annotation.tts.type.PassengerType;
import com.sky.demo.common.annotation.tts.type.PolicyType;

import java.util.Collection;
import java.util.List;

/**
 * Created by rg on 15/6/27.
 */
public class DimensionService {

    private DimensionService(){

    }

    private static DimensionService INSTANCE = new DimensionService();

    public static DimensionService getInstance(){
        return INSTANCE;
    }


    public List<Object> filterDimension(Collection<Object> classes,Dimensions dimensions){

        List<Object> validClasses = Lists.newArrayList();

        for (Object aClass : classes) {
            TTS anno = aClass.getClass().getAnnotation(TTS.class);
            PolicyType[] policyTypes = anno.policy();
            PassengerType[] passengerTypes = anno.psg();
            ActionType[] actionTypes = anno.action();

            boolean pFind = false;
            boolean gFind = false;
            boolean aFind = false;

            for (PolicyType policyType : policyTypes) {
                if (policyType.equals(PolicyType.ALL) ||
                        policyType.equals(dimensions.getPolicyType())){
                    pFind = true;
                    break;
                }
            }

            for (PassengerType passengerType : passengerTypes){
                if (passengerType.equals(PassengerType.ALL) ||
                        passengerType.equals(dimensions.getPassengerType())){
                    gFind = true;
                    break;
                }
            }

            for (ActionType actionType : actionTypes) {
                if (actionType.equals(ActionType.ALL) ||
                        actionType.equals(dimensions.getActionType())) {
                    aFind = true;
                    break;
                }
            }

            if (pFind && gFind && aFind) {
                validClasses.add(aClass);
            }
        }

        return validClasses;
    }
}
