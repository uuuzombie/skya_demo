package com.sky.demo.io.excel.poi;

import org.junit.Test;

/**
 * Created by rg on 2015/7/21.
 */
public class ExcelFormatDemoTest {


    @Test
    public void test_createIndexedColorExcel() {

        ExcelFormatDemo demo = new ExcelFormatDemo();
        try {
            demo.createIndexedColorExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_createCellText() {

        ExcelFormatDemo demo = new ExcelFormatDemo();
        try {
            demo.createCellText();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
