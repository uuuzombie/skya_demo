package com.sky.demo.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    private String E1 = "[\u4e00-\u9fa5]";			//汉字
    private String E2 = "[a-zA-Z]";					//字母
    private String E3 = "[0-9]";					//数字

    private static Integer chineseChar = 0;
    private static Integer englishChar = 0;
    private static Integer numberChar = 0;

    private static final String pnrRegx = "\\w{3,} +\\w\\d? +\\w{7,9} {0,}\\w{6} *(\\w{2})\\d* +\\w{4} +\\w{4}(\\+\\d){0,1}";

    @Test
    public void test_String_matches(){

        String str = "中国abc11";

        String tempStr = null;
        for (int i = 0;i < str.length();++i){
            tempStr = String.valueOf(str.charAt(i));

            if (tempStr.matches(E1)){
                chineseChar++;
            } else if (tempStr.matches(E2)) {
                englishChar++;
            } else if (tempStr.matches(E3)) {
                numberChar++;
            }
        }

        System.out.println("chineseChar:" + chineseChar);
        System.out.println("englishChar:" + englishChar);
        System.out.println("numberChar:" + numberChar);
    }

    @Test
    public void test_Pattern_and_Matcher(){
        String str = "中国abc11";

        Pattern pattern1 = Pattern.compile(E1);
        Matcher matcher1 = pattern1.matcher(str);

        while(matcher1.find()){
            System.out.println("Match:" + matcher1.group());
        }
    }

}
