package com.sky.demo.io.dic_import;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by rg on 8/25/15.
 */
public class DicUtilTest {

    @Test
    public void test_import_dic() throws IOException {
        String path = "/test.dic";

        Map<String, Integer> result = DicUtil.importDic(path);
        System.out.println(result);


    }
}
