package com.sky.demo.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rg on 15/7/5.
 */
public class PnrMatch {

    private static final String regx = "\\w{3,} +\\w\\d? +\\w{7,9} {0,}\\w{6} *(\\w{2})\\d* +\\w{4} +\\w{4}(\\+\\d){0,1}";

    public static void getPnrCodeGroup(String testStr,int i){
        Matcher matcher = Pattern.compile(regx).matcher(testStr);
        while(matcher.find()){
            System.out.printf(matcher.group(i));
        }
    }

    public static String matchPnrCode(String testStr){
        Matcher matcher = Pattern.compile(regx).matcher(testStr);
        while(matcher.find()){
            System.out.printf(matcher.group());
        }
        return matcher.group(1);
    }

}
