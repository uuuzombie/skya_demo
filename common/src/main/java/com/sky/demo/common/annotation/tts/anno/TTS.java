package com.sky.demo.common.annotation.tts.anno;

import com.sky.demo.common.annotation.tts.type.ActionType;
import com.sky.demo.common.annotation.tts.type.PassengerType;
import com.sky.demo.common.annotation.tts.type.PolicyType;

import java.lang.annotation.*;

/**
 * Created by rg on 15/6/27.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface TTS {

    PolicyType[] policy() default PolicyType.ALL;

    PassengerType[] psg() default PassengerType.ALL;

    ActionType[] action() default ActionType.ALL;
}
