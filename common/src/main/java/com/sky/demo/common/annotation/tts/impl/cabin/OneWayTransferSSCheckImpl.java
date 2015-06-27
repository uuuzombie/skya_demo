package com.sky.demo.common.annotation.tts.impl.cabin;


import com.sky.demo.common.annotation.tts.anno.TTS;
import com.sky.demo.common.annotation.tts.impl.OTACabinCheckTemplate;
import com.sky.demo.common.annotation.tts.type.ActionType;
import com.sky.demo.common.annotation.tts.type.PassengerType;
import com.sky.demo.common.annotation.tts.type.PolicyType;

@TTS(policy = {PolicyType.OTA_ONE_WAY_TRANS_POLICY},psg = {PassengerType.ADULT,PassengerType.STUDENT},action = {ActionType.ALL})
public class OneWayTransferSSCheckImpl extends OTACabinCheckTemplate {

    private static final String Monitor = "One way Transfer ss check";

    @Override
    protected PolicyType getPolicy() {
        return null;
    }

    @Override
    protected String getMonitorMetric() {
        return Monitor;
    }
}
