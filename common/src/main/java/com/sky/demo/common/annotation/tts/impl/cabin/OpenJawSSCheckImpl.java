package com.sky.demo.common.annotation.tts.impl.cabin;


import com.sky.demo.common.annotation.tts.anno.TTS;
import com.sky.demo.common.annotation.tts.impl.OTACabinCheckTemplate;
import com.sky.demo.common.annotation.tts.type.ActionType;
import com.sky.demo.common.annotation.tts.type.PassengerType;
import com.sky.demo.common.annotation.tts.type.PolicyType;

@TTS(policy = {PolicyType.OTA_MULTI_TRANS_POLICY},psg = {PassengerType.ADULT,PassengerType.STUDENT},action = {ActionType.ALL})
public class OpenJawSSCheckImpl extends OTACabinCheckTemplate {

    private static final String Monitor = "Open jaw SS check";

    @Override
    protected PolicyType getPolicy() {
        return null;
    }

    @Override
    protected String getMonitorMetric() {
        return Monitor;
    }
}
