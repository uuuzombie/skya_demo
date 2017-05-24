package com.sky.demo.string;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rg on 15/6/28.
 */
public class StringTest {

    @Test
    public void test_equals(){

        String str1 = "abc";
        String str2 = new String(str1);

        assertTrue(str1.equals(str2));
        assertFalse(str1 == str2);        //两个对象，str1地址跟str2地址不同

    }

    @Test
    public void test_equals_with_intern() {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        String str3 = "he" + "llo";
        String str4 = new String("hello");
        String str5 = new String("hello");

        assertFalse(str1 == str2);
        assertTrue(str1.equals(str2));
        assertTrue(str1 == str2.intern());  //对于任何两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true

        assertTrue(str1 == str3);  //两者在编译期就被解析为一个字符串常量

        assertFalse(str1 == str4);  //用new String() 创建的字符串不是常量，不能在编译期就确定
        assertFalse(str2 == str4);
        assertFalse(str4 == str5);

    }

    @Test
    public void test_StringUtils_equals(){
        String str = "-1";
        assertTrue(StringUtils.equals(str, "-1"));
    }

    @Test
    public void test_String_length(){
        String str = "SSR DOCS HX HK1 P/US/463576705/CN/25Aug70/F/27Sep19/OVERINGTON/JENNIFER ELIZABE";
        System.out.println(str.length());
    }

    @Test
    public void test_subString(){
//        String str = null;
//        String str = "";
        String str = "a";
        String subStr1 = str.substring(0,1);    //beginIndex,endIndex
        String subStr2 = str.substring(1);      //beginIndex

        System.out.println(subStr1);
        System.out.println(subStr2);

        assertTrue(!subStr1.equals(subStr2));
    }

    @Test
    public void test_spilt(){
        String testStr = "  a ab";
        String str[] = testStr.trim().split("\\s");
        System.out.println(StringUtils.join(str,","));
    }

    @Test
    public void test_append(){
        String code = "11";
        StringBuilder sb = new StringBuilder();

        sb.append(code.length() == 1 ? "0" : "").append(code);
        System.out.println(sb.toString());

    }

    @Test
    public void test_BigDecimal(){

        String a = "123.00";
        BigDecimal bigDecimal = new BigDecimal(a);
        System.out.println(bigDecimal);
    }

    @Test
    public void test_indexOf() {

        List<String> list = Lists.newArrayList(new String[]{
                "combination",
                "combination.mobile.app.android",
                "combination.mobile.app.iphone",
                "mobile.app.android",
                "mobile.app.iphone",
                "mobile.wap.padtouch",
                "mobile.wap.touch",
                "self",
                "B2B_OTA",
                "baidu.zhixin.flightcard",
                "mobile.app.iphone.en",
                "_B2B_PNRIMPORT",
                "mobile.app.android.en",
                "business.airline.bayon",
                "null",
                "mail_inter_search_pa",
                "inter_baitour"});
        System.out.println( list);

        for (String str : list) {
            if (str.indexOf("mobile") >= 0) {
                System.out.println(str);
            }
        }
    }


    @Test
    public void test_toCharArray() {
        String str = "ab中国|*人￥！c";
        char[] charArray = str.toCharArray();
        System.out.println(charArray);

        for (char ch : charArray) {
            System.out.println(ch);
        }
    }
}
