package com.sky.demo.string.util;

import org.junit.Test;

/**
 * Created by rg on 15/6/28.
 */
public class StringUtilTest {

    @Test
    public void test_appendSSR(){

        //String ssrStr = "SSR DOCS HX HK1 P/US/463576705/US/25Aug70/F/27Sep19/OVERINGTON/JENNIFER ELIZABETH/H/P1";
        //String ssrStr = "SSR DOCS CA HK1 P/US/1234567890123/US/16Jan80/F/31Oct17/MICHAELWILL/HEFFRRDANMIR JORDANMISS/H/P1";
        String ssrStr = "SSR DOCS CA HK1 P/US/123456789012/US/16Jan80/F/31Oct17/MICHAELWILL/HEFFRRDANMIR JORDANMISS/H/P1";
        //String ssrStr = "SSR DOCS HX HK1 P/US/463576705/US/25Aug70/F/27Sep19/OVERINGTON/JENNIFER ELIZABETH/H/P1 +++ SSR DOCS HX HK1 P/US/463576705/US/25Aug70/F/27Sep19/OVERINGTON/JENNIFER ELIZABETH/H/P1 +++ SSR DOCS HX HK1 P/US/463576705/US/25Aug70/F/27Sep19/OVERINGTON/JENNIFER ELIZABETH/H/P1";
        //String ssrStr = "SSR DOCS HX HK1 P/US/463576705/US/25Aug70/F/27Sep19/OVERINGTON/JENNIFER   A/H/P1";
        StringBuilder sb = new StringBuilder();
        System.out.println(ssrStr.length());

        StringUtil.appendSSR(sb, ssrStr);
        System.out.println(sb);

    }
}
