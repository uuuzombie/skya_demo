package com.sky.demo.io.import_dic;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by rg on 8/25/15.
 */
public class DicUtilTest {

    @Test
    public void test_importDic() throws IOException {
        String path = "/dic.txt";

        Map<String, Integer> result = DicUtil.importDic(path);
        System.out.println(result);
    }

    @Test
    public void test_importDicByGuava() {
        String path = "/dic.txt";

        Map<String, Integer> result = DicUtil.importDicByGuava(path);
        System.out.println(result);
    }
}
