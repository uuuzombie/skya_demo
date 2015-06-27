package com.sky.demo.common.annotation.tts.interfaces;

import com.sky.demo.common.annotation.tts.anno.DimensionInterface;
import com.sky.demo.common.annotation.tts.bean.BookingContext;

/**
 * Created by rg on 15/6/27.
 */
@DimensionInterface
public interface IBookingFlightTimeCheck {

    public boolean process(BookingContext context) throws Exception;
}
