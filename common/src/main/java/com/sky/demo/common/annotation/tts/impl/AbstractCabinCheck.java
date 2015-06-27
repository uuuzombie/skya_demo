package com.sky.demo.common.annotation.tts.impl;


import com.sky.demo.common.annotation.tts.bean.BookingContext;
import com.sky.demo.common.annotation.tts.interfaces.IBookingCabinCheck;

public abstract class AbstractCabinCheck implements IBookingCabinCheck {

    @Override
    public boolean process(BookingContext bookingContext) throws Exception {
        //do something
        return checkCabin(bookingContext);
    }

    protected abstract boolean checkCabin(BookingContext bookingContext) throws Exception;
}
