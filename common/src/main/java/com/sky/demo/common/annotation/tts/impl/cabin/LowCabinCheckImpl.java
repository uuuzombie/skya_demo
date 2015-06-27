package com.sky.demo.common.annotation.tts.impl.cabin;


import com.sky.demo.common.annotation.tts.anno.TTS;
import com.sky.demo.common.annotation.tts.bean.BookingContext;
import com.sky.demo.common.annotation.tts.impl.AbstractCabinCheck;
import com.sky.demo.common.annotation.tts.type.ActionType;
import com.sky.demo.common.annotation.tts.type.PassengerType;
import com.sky.demo.common.annotation.tts.type.PolicyType;

@TTS(policy = {PolicyType.SSS, PolicyType.GTT}, psg = {PassengerType.ADULT}, action = ActionType.ALL)
public class LowCabinCheckImpl extends AbstractCabinCheck {
    @Override
    protected boolean checkCabin(BookingContext bookingContext) throws Exception {
        return true;
    }
}
