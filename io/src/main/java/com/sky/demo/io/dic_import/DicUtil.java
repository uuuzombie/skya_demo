package com.sky.demo.io.dic_import;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

/**
 * Created by rg on 8/25/15.
 */
public class DicUtil {

    public static Map<String, Integer> import_dic(String path) throws IOException {

//        URL resource = DicUtil.class.getResource(path);
//        Preconditions.checkNotNull(resource);

//        File inputFile = new File(resource.getFile());
        File inputFile = new File(path);
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
        } finally {
            if (br != null) {
                br.close();
            }
        }

        return result;
    }

    private static void parseLineToDic(String line, Map<String, Integer> result) {

        List<String> kv = Splitter.on("\t").omitEmptyStrings().trimResults().splitToList(line);
        result.put(kv.get(0), Integer.valueOf(kv.get(1)));

    }


}
