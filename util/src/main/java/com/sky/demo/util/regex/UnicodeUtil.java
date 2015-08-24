package com.sky.demo.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rg on 8/23/15.
 */
public class UnicodeUtil {

    /**
     * 编码
     * @param str
     * @return
     */
    public static String encodeUnicode(String str) {

        StringBuilder unicodeStr = new StringBuilder();
        char[] utfBytes = str.toCharArray();
        for (int i = 0 ;i < utfBytes.length; ++i) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeStr.append("\\u").append(hexB);
        }

        return unicodeStr.toString();
    }

//    public static String encodeUnicode(char ch) {
//
//        StringBuilder unicodeStr = new StringBuilder();
//
//        String hexB = Integer.toHexString(ch);
//        if (hexB.length() <= 2) {
//            hexB = "00" + hexB;
//        }
//        unicodeStr.append("\\u").append(hexB);
//
//        return unicodeStr.toString();
//    }


    /**
     * 编码 替换字符串中的中文为 unicode
     * @param str
     * @return
     */
    public static String encodeUnicodeOfCn(String str) {
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            String unicode = encodeUnicode(matcher.group());
            str = str.replace(matcher.group(), unicode);
        }
        return str;
    }


    /**
     * 解码 只能解析规则的unicode
     * @param unicodeStr
     * @return
     */
    public static String decodeUnicode(String unicodeStr) {
        int start = 0;
        int end = 0;

        final StringBuilder result = new StringBuilder();
        while (start > -1) {
            end = unicodeStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = unicodeStr.substring(start + 2, unicodeStr.length());
            } else {
                charStr = unicodeStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16);     // 16进制parse整形字符串。
            result.append(new Character(letter).toString());
            start = end;
        }
        return result.toString();
    }

    /**
     * 解码 根据正则匹配出的结果进行解码，可解析不规则字符串
     * @param str
     * @return
     */
    public static String decodeUnicodeByRegex(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }





}
