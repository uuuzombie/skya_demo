package com.sky.demo.io.file_demo;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.io.Closeables;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * Created by rg on 15/6/28.
 */
public class FileUtil {

    private static List<String> fileList = Lists.newArrayList();

    /**
     * 读取某一文件夹下所有文件，不包括子文件夹
     *
     * @param path
     * @return
     */
    public static List<String> getFileListFromSingleFolder(String path) {
        List<String> fileList = Lists.newArrayList();

        File inputFile = new File(path);
        Preconditions.checkState(inputFile.exists() && inputFile.isDirectory());

        File[] files = inputFile.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                fileList.add(file.toString());
            }
        }
        return fileList;
    }

    /**
     * 获取一个文件夹下所有文件，包括子文件下的 结果存入全局变量，采用递归方式
     *
     * @param path
     * @return
     */
    public static List<String> getFileList(String path) {
        File inputFile = new File(path);        //会读取绝对路径
        Preconditions.checkState(inputFile.exists());

        //另一种读取文件方式，更安全
//        URL resource = FileUtil.class.getResource(path);
//        Preconditions.checkNotNull(resource);
//        File inputFile = new File(resource.getPath());
//        Preconditions.checkState(inputFile.exists());

        File[] files = inputFile.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    getFileList(file.toString());
                } else if (file.isFile()) {
                    fileList.add(file.toString());
                }
            }
        }
        return fileList;
    }


    /**
     * 读取路径
     * @param path
     * @return
     */
    public static URL readPath(String path) {
        URL absolutePath = FileUtil.class.getResource(path);
        return absolutePath;
    }


    /**
     * 常规读取文件，采用BufferedReader
     *
     * @param path
     * @throws IOException
     */
    public static void readFile(String path) throws IOException {

        //File inputFile = new File(this.getClass().getResource(path).getFile()); // 如果path路径文件不存在，则会NPE

        //另一种读取文件方式，更安全
        URL resource = FileUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);

        File inputFile = new File(resource.getFile());
        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "utf-8"));

            String line;
            while ((line = br.readLine()) != null) {
                //TODO
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    /**
     * 写文件，采用PrintStream
     *
     * @param path 输出结果文件
     */
    public static void writeFile(String path) {
        //File outputFile = new File(path);    //文件不需要提前建好

        File outputFile = new File(FileUtil.class.getResource(path).getFile()); // 如果path路径文件不存在，则会NPE
        if (outputFile.exists()) {
            outputFile.delete();
        }

        try {
            outputFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintStream printStream = null;
        try {
            printStream = new PrintStream(outputFile);

            printStream.println("Something");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }
    }

    /**
     * 另一种写文件方法，采用BufferedWriter
     *
     * @param filePath 结果存放目录，不用提前建好result.txt
     * @throws IOException
     */
    public static void writeFileByBuffer(String filePath) throws IOException {

        URL absolutePath = FileUtil.class.getResource(filePath);
        System.out.println(absolutePath);

        File file = new File(absolutePath.getPath() + File.separatorChar + "result.txt"); //根据给出的存放路径，存放结果文件
        if (!file.exists() && !file.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }

        BufferedWriter bw = null;
        boolean threw = true;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

            bw.write("Something");

            threw = false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            Closeables.close(bw, threw);     // If an exception occurs, rethrow it only if threw==false
        }

    }
}
