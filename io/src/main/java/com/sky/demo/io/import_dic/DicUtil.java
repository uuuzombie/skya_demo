package com.sky.demo.io.import_dic;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import org.apache.commons.collections.CollectionUtils;

/**
 * Created by rg on 8/25/15.
 */
public class DicUtil {

    /**
     * 导入字典， 以 "," 分割
     * @param path
     * @return
     * @throws IOException
     */
    public static Map<String, Integer> importDic(final String path) {

        URL resource = DicUtil.class.getResource(path);     //  target/test-classes
        Preconditions.checkNotNull(resource);
        File inputFile = new File(resource.getFile());

//        File inputFile = new File(path);      //绝对路径
        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        Map<String, Integer> result = Maps.newHashMap();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "utf-8"));

            String line;
            while ((line = br.readLine()) != null) {
                parseLineToDic(line,result);
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
        return result;
    }

    private static void parseLineToDic(String line, Map<String, Integer> result) {
        List<String> list = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(line);
        if (CollectionUtils.isNotEmpty(list) && list.size() == 2 ) {
            result.put(list.get(0), Integer.valueOf(list.get(1)));
        }
    }


    public static Map<String, Integer> importDicByGuava(String path) {

        URL resource = DicUtil.class.getResource(path);     //  target/test-classes
        Preconditions.checkNotNull(resource);
        File inputFile = new File(resource.getFile());

//        File inputFile = new File(path);      //绝对路径
        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        Map<String, Integer> ret = Maps.newHashMap();
        try {
            ret = Files.readLines(inputFile, Charsets.UTF_8, new LineProcessor<Map<String, Integer>>() {
                Map<String, Integer> result = Maps.newHashMap();

                @Override
                public boolean processLine(String line) throws IOException {
                    List<String> list = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(line);
                    if (CollectionUtils.isNotEmpty(list) && list.size() == 2 ) {
                        result.put(list.get(0), Integer.valueOf(list.get(1)));
                    }
                    return true;
                }

                @Override
                public Map<String, Integer> getResult() {
                    return result;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
