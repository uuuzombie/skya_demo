package com.sky.demo.string.util;

/**
 * Created by rg on 15/6/28.
 */
public class StringUtil {

    public static void appendSSR(StringBuilder sb,String ssrStr){
        int PID_INSTRUCT_LENGTH = 80;

        //String ssrStr = ssr.toString();
        //SSR指令长度如果超过80，则需要换行，且第二行需要加空格
        int count = ssrStr.length() / PID_INSTRUCT_LENGTH;
        if (count > 0) {
            for (int i = 0;i < count;++i) {
                if (i == 0) {
                    sb.append(ssrStr.substring(0, PID_INSTRUCT_LENGTH)).append("\n- ");

                } else {
                    sb.append(ssrStr.substring(PID_INSTRUCT_LENGTH + (i - 1 ) * (PID_INSTRUCT_LENGTH - 2),PID_INSTRUCT_LENGTH + i * (PID_INSTRUCT_LENGTH - 2))).append("\n- ");
                }
            }
            sb.append(ssrStr.substring(PID_INSTRUCT_LENGTH + (count - 1) * (PID_INSTRUCT_LENGTH - 2)));
        }else {
            sb.append(ssrStr);
        }
    }

    public static void appendSSR2(StringBuilder sb,String ssrStr){
        int PID_INSTRUCT_LENGTH = 79;

        //String ssrStr = ssr.toString();
        //SSR指令长度如果超过80，则需要换行，且第二行需要加空格
        if (ssrStr.length() > PID_INSTRUCT_LENGTH) {
            sb.append(ssrStr.substring(0,PID_INSTRUCT_LENGTH).trim()).append("\n- ");
            sb.append(ssrStr.substring(PID_INSTRUCT_LENGTH).trim()).append("\n");
        }else {
            sb.append(ssrStr);
        }
    }
}
