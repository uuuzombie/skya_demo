package com.sky.demo.io.code;

import com.google.common.primitives.Bytes;

import java.util.Base64;
import java.util.List;

/**
 * Created by rg on 2016/1/14.
 */
public class CodeUtil {


    /**
     * 将byte 列表编码成Base64码
     * @param byteList
     * @return
     */
    public static String encodeByBase64(List<Byte> byteList) {
        byte[] bytes = Bytes.toArray(byteList);
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 将Base64码 解码
     * @param encodeString
     * @return
     */
    public static byte[] decodeByBase64(String encodeString) {
        return Base64.getDecoder().decode(encodeString);
    }

}
