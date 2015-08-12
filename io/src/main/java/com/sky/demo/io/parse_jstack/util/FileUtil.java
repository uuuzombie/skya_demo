package com.sky.demo.io.parse_jstack.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.sky.demo.io.parse_jstack.model.ConditionInfo;

import java.io.*;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rg on 15/6/28.
 */
public class FileUtil {

    private static final String MATCH_STRING = "waiting on condition";

    /**
     * 读取文件
     * @param path 文件路径
     * @return 返回过滤后的字符串链表
     * @throws IOException
     */
    public static List<String> readFile(String path) throws IOException {

        String p = FileUtil.class.getResource(path).toString();    //注意路径前面的 file:
        System.out.println(p);

//      File file = new File(this.getClass().getResource(path).getFile());
//        if (!file.exists()) {
//            throw new FileNotFoundException("No such file!");
//        }


        URL resource = FileUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);

        File file = new File(resource.getFile());
        Preconditions.checkState(file.exists() && file.isFile());


        String regx = "\\[.+\\]";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher;

        BufferedReader br = null;
        List<String> listStrings = Lists.newArrayList();
        try {
            String line,tempLine;

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
            while((line = br.readLine()) != null){
                matcher = pattern.matcher(line);

                if (line.contains(MATCH_STRING) && matcher.find()) {
                    //listStrings.add(line);
                    tempLine = line;

                    if ((line = br.readLine()) != null) {
                        tempLine += line;
                        listStrings.add(tempLine);
                    }
                }
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    throw e;
                }
            }
        }
        return listStrings;
    }


    /**
     * 对输入的结果进行排序，并输出到文件
     * @param map
     * @param path 文件路径，需要提前建好，否则会抛出NPE
     * @throws FileNotFoundException
     */
    public static void outputResult(Multimap<String, String> map, List<ConditionInfo> listConditionInfos, String path) throws IOException {

        //File outputFile = new File(path);    //文件不需要提前建好
        File outputFile = new File(FileUtil.class.getResource(path).getFile());    //文件需要提前建好
        if (outputFile.exists()){
            outputFile.delete();
        }

        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }
//        try {
//            outputFile.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        PrintStream printStream = null;
        try{
            printStream = new PrintStream(outputFile);

            //写入文件
            for (ConditionInfo conditionInfo : listConditionInfos) {

                printStream.println(conditionInfo.getConditionId() + ",count:" + conditionInfo.getCount() + ":");

                Collection<String> collection = map.get(conditionInfo.getConditionId());
                for (String str : collection) {
                    printStream.println(str);
                }
            }
        } finally {
            try {
                if (printStream != null) {
                    printStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
