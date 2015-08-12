package com.sky.demo.io.count_character;

import com.sky.demo.io.count_character.service.Reportable;
import com.sky.demo.io.count_character.util.FileOpt;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by rg on 15/6/28.
 *
 * 1、查找一个目录下，所有文件中数字、字母(大小写不区分)、汉字、空格的个数、行数。
 * 2、将结果数据写入到文件中。
 * 文件格式如下：
 * 数字：198213个
 * 字母：18231个
 * 汉字：1238123个
 * 空格：823145个
 * 行数：99812行
 *
 * 数字0：123个
 * 数字1：1214个
 * 数字2：23423个
 * 数字3：53453个
 * 数字4：35346个
 * 数字5：3452346个
 * 数字6：34534个
 * 数字7：3246346个
 * 数字8：3246346个
 * 数字9：346436个
 * 字母A：754456个
 * 数字B：7567个
 * 数字C：456456个
 * ……
 */
public class FileOptTest {

    @Test
    public void test_getResource() {
        System.out.println(this.getClass().getResource(""));
        System.out.println(FileOpt.class.getResource("/"));
        System.out.println(this.getClass().getResource("test.txt"));
        System.out.println(FileOpt.class.getResource("/test.txt"));
    }

    @Test
    public void test_readFile() {
        String inputPath = "/test.txt";
        String outputPath = "/result.txt";

        List<Reportable> result = null;
        try {
            result = FileOpt.readFile(inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Reportable reportable : result) {
            System.out.println(reportable.getSummary());
            System.out.println(reportable.getDetail());
        }

        //FileOpt.writeFile(result,outputPath);
    }





}
