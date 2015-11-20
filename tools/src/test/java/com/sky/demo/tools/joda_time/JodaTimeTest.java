package com.sky.demo.tools.joda_time;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * Created by rg on 2015/11/20.
 */
public class JodaTimeTest {

    private static final String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_YYYY_MM_DD = "yyyy-MM-dd";

    @Test
    public void test_constructor() {
        DateTime now = new DateTime();
        System.out.println(now);

        System.out.println(now.toString());
        System.out.println(now.toString(DATE_YYYY_MM_DD_HH_MM_SS));
    }

    @Test
    public void test_minus() {
        DateTime now = new DateTime();
        System.out.println(now.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        DateTime pre3Day = now.minusDays(3);
        System.out.println(pre3Day.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        DateTime pre24Hour = now.minusHours(24);
        System.out.println(pre24Hour.toString(DATE_YYYY_MM_DD_HH_MM_SS));
    }

    @Test
    public void test_dayOfYear() {
        DateTime now = new DateTime();
        System.out.println(now.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        DateTime pre = now.dayOfYear().withMinimumValue();
        String beginDate = pre.toString(DATE_YYYY_MM_DD_HH_MM_SS);
        System.out.println(beginDate);

        pre = now.dayOfYear().withMaximumValue();
        String endDate = pre.toString(DATE_YYYY_MM_DD_HH_MM_SS);
        System.out.println(endDate);

        pre = now.dayOfYear().roundFloorCopy();
        System.out.println(pre.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        pre = now.dayOfYear().roundCeilingCopy();
        System.out.println(pre.toString(DATE_YYYY_MM_DD_HH_MM_SS));

    }


    @Test
    public void test_dayOfMonth() {
        DateTime now = new DateTime();
        System.out.println(now.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        DateTime pre = now.dayOfMonth().withMinimumValue();
        String beginDate = pre.toString(DATE_YYYY_MM_DD_HH_MM_SS);
        System.out.println(beginDate);

        pre = now.dayOfMonth().withMaximumValue();
        String endDate = pre.toString(DATE_YYYY_MM_DD_HH_MM_SS);
        System.out.println(endDate);

        pre = now.dayOfMonth().roundFloorCopy();
        System.out.println(pre.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        pre = now.dayOfMonth().roundCeilingCopy();
        System.out.println(pre.toString(DATE_YYYY_MM_DD_HH_MM_SS));

    }

    @Test
    public void test_dayOfWeek() {
        DateTime now = new DateTime();
        System.out.println(now.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        DateTime pre = now.dayOfWeek().withMinimumValue();
        String beginDate = pre.toString(DATE_YYYY_MM_DD_HH_MM_SS);
        System.out.println(beginDate);

        pre = now.dayOfWeek().withMaximumValue();
        String endDate = pre.toString(DATE_YYYY_MM_DD_HH_MM_SS);
        System.out.println(endDate);

        pre = now.dayOfWeek().roundFloorCopy();
        System.out.println(pre.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        pre = now.dayOfWeek().roundCeilingCopy();
        System.out.println(pre.toString(DATE_YYYY_MM_DD_HH_MM_SS));
    }

    @Test
    public void test_yesterday() {
        DateTime now = new DateTime();
        System.out.println(now.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        DateTime pre = now.minusDays(1);
        String beginDate = pre.toString(DATE_YYYY_MM_DD) + " 00:00:00";
        System.out.println(beginDate);

        String endDate = pre.toString(DATE_YYYY_MM_DD) + " 23:59:59";
        System.out.println(endDate);

    }

    @Test
    public void test_secondOfDay() {
        DateTime now = new DateTime();
        System.out.println(now.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        DateTime pre = now.secondOfDay().withMinimumValue();
        String beginDate = pre.toString(DATE_YYYY_MM_DD_HH_MM_SS);
        System.out.println(beginDate);


        pre = now.secondOfDay().withMaximumValue();
        String endDate = pre.toString(DATE_YYYY_MM_DD_HH_MM_SS);
        System.out.println(endDate);

        pre = now.secondOfDay().roundFloorCopy();
        System.out.println(pre.toString(DATE_YYYY_MM_DD_HH_MM_SS));

        pre = now.secondOfDay().roundCeilingCopy();
        System.out.println(pre.toString(DATE_YYYY_MM_DD_HH_MM_SS));
    }


}
