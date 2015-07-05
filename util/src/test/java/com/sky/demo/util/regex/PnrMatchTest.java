package com.sky.demo.util.regex;

import org.junit.Test;

public class PnrMatchTest {

    private String testStr = "2. OZ334 H SU12AUG PEKICN HK1 1520 1820 E";

    @Test
    public void test_getPnrCodeGroup(){
        PnrMatch.getPnrCodeGroup(testStr, 0);
        System.out.println();
        PnrMatch.getPnrCodeGroup(testStr, 1);
        System.out.println();
        PnrMatch.getPnrCodeGroup(testStr,2);
        //String.split();
    }


}
