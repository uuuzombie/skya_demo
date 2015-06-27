package com.sky.demo.common.annotation.tts.impl.time;


import com.sky.demo.common.annotation.tts.anno.TTS;
import com.sky.demo.common.annotation.tts.bean.BookingContext;
import com.sky.demo.common.annotation.tts.interfaces.IBookingWorkTimeCheck;
import com.sky.demo.common.annotation.tts.type.ActionType;
import com.sky.demo.common.annotation.tts.type.PassengerType;
import com.sky.demo.common.annotation.tts.type.PolicyType;

@TTS(policy = {PolicyType.ALL},psg = {PassengerType.ALL},action = {ActionType.ALL})
public class BookingWorkTimeCheck implements IBookingWorkTimeCheck {
    @Override
    public boolean process(BookingContext bookingContext) throws Exception {
        return false;
    }
}
