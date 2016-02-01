package com.sky.demo.io.file_demo;

import java.io.*;
import java.net.URL;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.io.Closeables;
import com.google.common.io.Closer;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

/**
 * Created by rg on 15/6/28.
 */
public class FileUtil {

    private static List<String> fileList = Lists.newArrayList();

    /**
     * 读取某一文件夹下所有文件，不包括子文件夹
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
    public static URL getPath(String path) {
        URL resource = FileUtil.class.getResource(path);
        return resource;
    }

    /**
     * 读取路径
     * @param path
     * @return
     */
    public static String getAbsolutePath(String path) {
        URL resource = FileUtil.class.getResource(path);
        return resource == null ? null : resource.getPath();
    }

    /**
     * 读取jar包中配置文件
     * 无论是在打jar包之前还是之后都可以正确读取conf.properties文件中的信息
     * @param fileName
     * @return
     */
    public static InputStream getConfigFromJar(String fileName) {
        InputStream in = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
        return in;
    }


    //===============================================================

    /**
     * BufferedReader 字符流
     * 读取文件 以行为单位读取文件，常用于读面向行的格式化文件n
     * @param path
     * @throws IOException
     */
    public static void readFileByBufferedReader(String path) {
        //1.绝对路径     path = "/" -> D:\\ or /
        //File inputFile = new File(path);

        //2.Resource    path = "/" -> demo/io/target/classes/
        URL resource = FileUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);
        File inputFile = new File(resource.getFile());

        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        BufferedReader br = null;
        try {
            //InputStreamReader 是一个连接字节流和字符流的桥梁，它将字节流转变为字符流
            br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "utf-8"));

            int i = 1;
            String line;
            while ((line = br.readLine()) != null) {
                //TODO
                i = process(i, line);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static int process(int i, String line) {
        System.out.println(i++ + ":" + line);
        return i;
    }


    /**
     * BufferedWriter 字符流
     * 写文件
     *
     * @param path
     * @param content
     * @throws IOException
     */
    public static void writeFileByBufferedWriter(String path, String content) throws IOException {
        //1.绝对路径     path = "/" -> D:\\ or /
        //File outputFile = new File(path);

        //2.Resource    path = "/" -> demo/io/target/classes/
        URL resource = FileUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);
        File outputFile = new File(resource.getPath());     // + File.separatorChar + "result.txt"

        if (outputFile.exists()) {
            outputFile.delete();
        }
        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }

        BufferedWriter bw = null;
        try {
            //OutputStreamWriter 是OutputStream 到Writer 转换的桥梁
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));

            bw.write(content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    /**
     * BufferedWriter 字符流
     * 写文件
     * @param path
     * @param content
     * @throws IOException
     */
    public static void writeFileByBufferedWriterUseCloseables(String path, String content) throws IOException {
        //1.绝对路径     path = "/" -> D:\\ or /
        //File outputFile = new File(path);

        //2.Resource    path = "/" -> demo/io/target/classes/
        URL resource = FileUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);

        //根据给出的存放路径，存放结果文件
        File outputFile = new File(resource.getPath());   // + File.separatorChar + "result.txt"
        if (outputFile.exists()) {
            outputFile.delete();
        }
        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }

        BufferedWriter bw = null;
        boolean threw = true;
        try {
            //OutputStreamWriter 是OutputStream 到Writer 转换的桥梁
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));

            bw.write(content);

            threw = false;
        } finally {
            Closeables.close(bw, threw);     // If an exception occurs, rethrow it only if threw==false
        }
    }


    /**
     * PrintStream  字符流
     * 写文件
     * PrintStream 也可以认为是一个辅助工具。主要可以向其他输出流，或者FileInputStream 写入数据，本身内部实现还是带缓冲的。
     * 本质上是对其它流的综合运用的一个工具而已
     * @param path
     * @param content
     */
    public static void writeFileByPrintStream(String path, String content) throws IOException {
        //1.绝对路径
        //File outputFile = new File(path);

        //2.Resource
        URL resource = FileUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);
        File outputFile = new File(resource.getFile());

        if (outputFile.exists()) {
            outputFile.delete();
        }
        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }

        PrintStream printStream = null;
        try {
            printStream = new PrintStream(outputFile);
            printStream.println(content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }
    }


    //===============================================================


    /**
     * BufferedInputStream 字节流
     * 读取文件到byte list中
     * @param path
     * @return
     */
    public static void readFileByBufferedInputStream(String path) {
        //1.绝对路径    path = "/" -> D:\\ or /
        //File inputFile = new File(path);

        //2.另一种读取文件方式，更安全   path = "/" -> demo/io/target/classes/
        URL resource = FileUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);
        File inputFile = new File(resource.getFile());

        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        List<Byte> byteList = Lists.newArrayList();
        BufferedInputStream bri = null;
        try {
            bri = new BufferedInputStream(new FileInputStream(inputFile));

            byte[] buffer = new byte[1024];
            int length = 0;
            String str;
            int i = 0;
            while ((length = bri.read(buffer)) != -1) {
                for (int j = 0; j < length; ++j) {
                    byteList.add(buffer[j]);
                }

                str = new String(buffer, 0, length);
                System.out.println(i + ":" + str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bri != null) {
                try {
                    bri.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * BufferedOutputStream 字节流
     * 写文件
     * @param path
     */
    public static void writeFileByBufferedOutputStream(String path, String content) throws IOException {
        //1.绝对路径
        //File outputFile = new File(path);

        //2.Resource
        URL resource = FileUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);
        File outputFile = new File(resource.getFile());

        if (outputFile.exists()) {
            outputFile.delete();
        }
        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }

        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(outputFile));

            byte[] bytes = content.getBytes();
            bos.write(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                bos.close();
            }
        }
    }


    //===============================================================

    /**
     * BufferedInputStream & BufferedOutputStream 字节流
     * 复制文件
     * @param inputPath
     * @param outputPath
     */
    public static void copyFileByBuffered(String inputPath, String outputPath) throws IOException {
        //1.绝对路径
        //File inputFile = new File(inputPath);
        //File outputFile = new File(outputPath);

        //2.Resource
        URL inputResource = FileUtil.class.getResource(inputPath);
        Preconditions.checkNotNull(inputResource);
        File inputFile = new File(inputResource.getFile());

        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        URL outputResource = FileUtil.class.getResource(outputPath);
        Preconditions.checkNotNull(outputPath);
        File outputFile = new File(outputResource.getFile());

        if (outputFile.exists()) {
            outputFile.delete();
        }
        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(inputFile));
            bos = new BufferedOutputStream(new FileOutputStream(outputFile));

            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
                bos.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }


    /**
     * 复制文件
     * since JDK7, try里面所有实现接口java.lang.AutoCloseable，包括java.io.Closeable的对象，在{}的语句块执行完毕后都会自动的close
     * @param inputPath
     * @param outputPath
     */
    public static void copyFileByTryWithResources(String inputPath, String outputPath) throws IOException {
        //1.绝对路径
        //File inputFile = new File(inputPath);
        //File outputFile = new File(outputPath);

        //2.Resource
        URL inputResource = FileUtil.class.getResource(inputPath);
        Preconditions.checkNotNull(inputResource);
        File inputFile = new File(inputResource.getFile());

        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        URL outputResource = FileUtil.class.getResource(outputPath);
        Preconditions.checkNotNull(outputPath);
        File outputFile = new File(outputResource.getFile());

        if (outputFile.exists()) {
            outputFile.delete();
        }
        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }


        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile));
        ) {

            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
                bos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制文件
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void copyFileByBufferedUseCloser(String inputPath, String outputPath) throws IOException {
        //1.绝对路径
        //File inputFile = new File(inputPath);
        //File outputFile = new File(outputPath);

        //2.Resource
        URL inputResource = FileUtil.class.getResource(inputPath);
        Preconditions.checkNotNull(inputResource);
        File inputFile = new File(inputResource.getFile());

        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        URL outputResource = FileUtil.class.getResource(outputPath);
        Preconditions.checkNotNull(outputPath);
        File outputFile = new File(outputResource.getFile());

        if (outputFile.exists()) {
            outputFile.delete();
        }
        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }

        Closer closer = Closer.create();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = closer.register(new BufferedInputStream(new FileInputStream(inputFile)));
            bos = closer.register(new BufferedOutputStream(new FileOutputStream(outputFile)));

            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
                bos.flush();
            }

        } catch (Throwable e) {
            throw closer.rethrow(e);
        } finally {
            closer.close();
        }

    }

    /**
     * 复制文件
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void copyFileBySourceAndSink(String inputPath, String outputPath) throws IOException {
        //1.绝对路径
        //File inputFile = new File(inputPath);
        //File outputFile = new File(outputPath);

        //2.Resource
        URL inputResource = FileUtil.class.getResource(inputPath);
        Preconditions.checkNotNull(inputResource);
        File inputFile = new File(inputResource.getFile());

        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        URL outputResource = FileUtil.class.getResource(outputPath);
        Preconditions.checkNotNull(outputPath);
        File outputFile = new File(outputResource.getFile());

        if (outputFile.exists()) {
            outputFile.delete();
        }
        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }

        Files.asByteSource(inputFile).copyTo(Files.asByteSink(outputFile, FileWriteMode.APPEND));

    }
}
