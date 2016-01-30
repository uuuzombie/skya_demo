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
    public void test_getResource() {
        System.out.println(this.getClass().getResource(""));            // demo/io/target/test-classes/com/sky/demo/io/file_demo/
        System.out.println(this.getClass().getResource("/"));           // demo/io/target/test-classes/
        System.out.println(this.getClass().getResource("test.txt"));    // null
        System.out.println(this.getClass().getResource("/test.txt"));   // demo/io/target/test-classes/test.txt

        System.out.println(FileUtil.class.getResource(""));             // demo/io/target/test-classes/com/sky/demo/io/file_demo/
        System.out.println(FileUtil.class.getResource("/"));            // demo/io/target/test-classes/
        System.out.println(FileUtil.class.getResource("test.txt"));     // null
        System.out.println(FileUtil.class.getResource("/test.txt"));    // demo/io/target/test-classes/test.txt
    }


    @Test
    public void test_getFileListFromSingleFolder(){
        String path = "/";

        List<String> fileList = FileUtil.getFileListFromSingleFolder(path);
        System.out.println(fileList);
    }

    @Test
    public void test_getFileList(){
        String path = "/test";
        //String path = "";  //getResource() 方式，读取路径不能加 /

        List<String> fileList = FileUtil.getFileList(path);
        for (String str : fileList) {
            System.out.println(str);
        }
    }

    @Test
    public void test_getPath(){
        String path1 = "/test.txt";
        System.out.println(FileUtil.getPath(path1));   // demo/io/target/classes/test.txt

        String path2 = "test.txt";
        System.out.println(FileUtil.getPath(path2));   // demo/io/target/classes/com/sky/demo/test.txt

        String path3 = "D:\\test.txt";
        System.out.println(FileUtil.getPath(path3));   //error

    }

    @Test
    public void test_getAbsolutePath() {

        String path1 = "/test.txt";
        System.out.println(FileUtil.getAbsolutePath(path1));   // demo/io/target/classes/test.txt

        String path2 = "test.txt";
        System.out.println(FileUtil.getAbsolutePath(path2));   // demo/io/target/classes/com/sky/demo/test.txt

        String path3 = "D:\\test.txt";
        System.out.println(FileUtil.getAbsolutePath(path3));   //error

    }



    //===============================================================

    @Test
    public void test_readFileByBufferedReader() throws IOException {
        String path = "/test.txt";
        FileUtil.readFileByBufferedReader(path);
    }

    @Test(expected = NullPointerException.class)
    public void test_readFileByBufferedReader_input_file_not_exist() throws IOException {
        String path = "/fileNotExist.txt";
        FileUtil.readFileByBufferedReader(path);
    }

    @Test
    public void test_writeFileByBufferedWriter() throws IOException {
        String path = "/result.txt";  // demo/io/target/classes/result.txt
        String content = "Hello world\n write file";
        FileUtil.writeFileByBufferedWriter(path, content);
    }

    @Test(expected = NullPointerException.class)
    public void test_writeFileByBufferedWriter_result_file_not_exist() throws IOException {
        String path = "/fileNotExist.txt";
        String content = "Hello world\n write file";
        FileUtil.writeFileByBufferedWriter(path, content);
    }

    @Test
    public void test_writeFileByBufferedWriterUseCloseables() throws IOException {
        String path = "/result.txt";                 // demo/io/target/classes/result.txt
        String content = "Hello world\nwrite file \nuse closeables";
        FileUtil.writeFileByBufferedWriterUseCloseables(path, content);
    }

    @Test
    public void test_writeFileByPrintStream() throws IOException {
        String filePath = "/result.txt";        // demo/io/target/classes/result.txt
        String content = "Hello world\n write file \nby print stream";
        FileUtil.writeFileByPrintStream(filePath, content);
    }

    @Test
    public void test_readFileByBufferedInputStream() {
        String path = "/test.txt";
        FileUtil.readFileByBufferedInputStream(path);
    }

    @Test
    public void test_writeFileByBufferedOutputStream() throws IOException {
        String path = "/result.txt";
        String content = "Hello world\nwrite file \nby BufferedOutputStream";
        FileUtil.writeFileByBufferedOutputStream(path, content);
    }


    //===============================================================

    @Test
    public void test_copyFileByTryWithResources() throws IOException {
        String inputPath = "/test.txt";
        String outputPath = "/result.txt";
        FileUtil.copyFileByBuffered(inputPath, outputPath);
    }

    @Test
    public void test_copyFileByBuffered() throws IOException {
        String inputPath = "/test.txt";
        String outputPath = "/result.txt";
        FileUtil.copyFileByBuffered(inputPath, outputPath);
    }

    @Test
    public void test_copyFileByBufferedUseCloser() throws IOException {
        String inputPath = "/test.txt";
        String outputPath = "/result.txt";
        FileUtil.copyFileByBufferedUseCloser(inputPath, outputPath);
    }

    @Test
    public void test_copyFileBySourceAndSink() throws IOException {
        String inputPath = "/test.txt";
        String outputPath = "/result.txt";
        FileUtil.copyFileBySourceAndSink(inputPath, outputPath);
    }

}
