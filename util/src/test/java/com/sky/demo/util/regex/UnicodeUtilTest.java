package com.sky.demo.util.regex;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by rg on 8/23/15.
 */
public class UnicodeUtilTest {

    @Test
    public void test_encodeUnicode() {

        List<String> stringList = Lists.newArrayList("abc","中国","中国ab人|abc| 历史");
        for (String str : stringList) {
            String result = UnicodeUtil.encodeUnicode(str);
            System.out.println(result);
        }

    }


    @Test
    public void test_decodeUnicode() {
        List<String> unicodeStrList = Lists.newArrayList("\\u0061\\u0062\\u0063",
                "\\u4e2d\\u56fd",
                "\\u8BF7\\u9009\\u62E9\\u5DE5\\u7A0B\\u6216\\u6587\\u4EF6",
                "\\u4e2d\\u56fdab\\u4eba|abc| \\u5386\\u53f2");         //解析错误

        for (String unicodeStr : unicodeStrList) {
            String result = UnicodeUtil.decodeUnicode(unicodeStr);
            System.out.println(result);
        }
    }


    @Test
    public void test_decodeUnicodeByRegex() {
        List<String> unicodeStrList = Lists.newArrayList("\\u0061ad*45\\u0062\\u0063abc",
                "\\u4e2d\\u56fd",
                "\\u8BF7\\u9009\\u62E9\\u5DE5\\u7A0B\\u6216\\u6587\\u4EF6",
                "\\u4e2d\\u56fdab\\u4eba|abc| \\u5386\\u53f2");

        for (String unicodeStr : unicodeStrList) {
            String result = UnicodeUtil.decodeUnicodeByRegex(unicodeStr);
            System.out.println(result);
        }
    }

    @Test
    public void test_encodeUnicodeOfCn() {
        List<String> unicodeStrList = Lists.newArrayList("abc","中国","中国ab人|abc| 历史");

        for (String unicodeStr : unicodeStrList) {
            String result = UnicodeUtil.encodeUnicodeOfCn(unicodeStr);
            System.out.println(result);
        }
    }
}
