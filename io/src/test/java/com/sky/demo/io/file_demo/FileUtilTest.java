package com.sky.demo.io.file_demo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by rg on 15/6/28.
 */
public class FileUtilTest {


    @Before
    public void setUp(){

    }


    @Test
    public void test_getFileListFromSingleFolder(){
        String path = "/";

        List<String> fileList = FileUtil.getFileListFromSingleFolder(path);
        System.out.println(fileList);
    }

    @Test
    public void test_getFileList(){
        String path = "/Users/rg/gitproject/sky_demo/io/";
        //String path = "";  //getResource() 方式，读取路径不能加 /

        List<String> fileList = FileUtil.getFileList(path);
        for (String str : fileList) {
            System.out.println(str);
        }
    }

    @Test
    public void test_readPath(){

        String path1 = "/test.txt";
        System.out.println(FileUtil.readPath(path1));   //在demo.io/file_demo/target/classes/test.txt

        String path2 = "test.txt";
        System.out.println(FileUtil.readPath(path2));   //在demo.io/file_demo/target/classes/com/sky/demo/test.txt

    }

    @Test
    public void test_readFile() throws IOException {
        String path = "/test.txt";
        FileUtil.readFile(path);
    }

    @Test(expected = NullPointerException.class)
    public void test_readFile_input_file_not_exist() throws IOException {
        String path = "/fileNotExist.txt";
        FileUtil.readFile(path);
    }

    @Test
    public void test_writeFile(){
        String path = "/result.txt";
        FileUtil.writeFile(path);
    }

    @Test(expected = NullPointerException.class)
    public void test_writeFile_result_file_not_exist(){
        String path = "fileNotExist.txt";
        FileUtil.writeFile(path);
    }

    @Test
    public void test_writeFileByBuffer() throws IOException {
        String path = "/";
        FileUtil.writeFileByBuffer(path);
    }



    @Test
    public void test_getAbsolutePath() {
        String fileName = "/text.txt";
        System.out.println(FileUtil.getAbsolutePath(fileName));

    }
}
