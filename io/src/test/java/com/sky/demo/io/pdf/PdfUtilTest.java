package com.sky.demo.io.pdf;

import org.junit.Test;

/**
 * Created by rg on 2015/7/21.
 */
public class PdfUtilTest {

    @Test
    public void test_createPDF() {
        PdfUtil.createPDF("d:/test.pdf");
    }

    @Test
    public void test_creatPDF2() {
        PdfUtil.createPDF2("d:/test2.pdf");
    }


    @Test
    public void test_createCNPdf() {

        PdfUtil.createCNPdf("D:\\chinese.pdf");
    }


    @Test
    public void test_createPDF3() {
        PdfUtil.creatPDF3("D:\\test3.pdf");
    }
}
