package com.sky.demo.common.annotation.tts.impl;


import com.sky.demo.common.annotation.tts.bean.BookingContext;
import com.sky.demo.common.annotation.tts.type.PolicyType;

public abstract class OTACabinCheckTemplate extends AbstractCabinCheck{

    @Override
    protected boolean checkCabin(BookingContext bookingContext) throws Exception {
        return false;
    }

    protected abstract PolicyType getPolicy();

    protected abstract String getMonitorMetric();
}
