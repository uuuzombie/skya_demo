package com.sky.demo.io.parse_snp;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by rg on 15/6/28.
 */
public class SNPUtilTest {

    @Test
    public void test_parseSNP() throws FileNotFoundException {
        String path = "/snp.txt";
        List<String> list = SNPUtil.parseSNP(path);

        String outputPath = "/snp_result.txt";
        SNPUtil.writeToFile(outputPath,list);
    }
}
