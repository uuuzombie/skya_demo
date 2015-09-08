package com.sky.demo.io.parse_snp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rg on 15/6/28.
 */
public class SNPUtil {

    public static List<String> parseSNP(String path) throws FileNotFoundException {
        File inputFile = new File(path);
        if (!inputFile.exists()){
            throw new FileNotFoundException("No such file!");
        }

        BufferedReader br = null;
        List<String> listString = new ArrayList<String>();
        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile),"utf-8"));

            StringBuilder sb = new StringBuilder();
            String line = null;
            boolean flag = false;
            while ((line = br.readLine()) != null){
                if (line.startsWith("rs")){
                    if (flag){
                        sb.delete(0,sb.length());
                    }

                    sb.append(line.substring(0,line.indexOf(' ')));
                    flag = true;
                }

                if (line.startsWith("CHROMOSOME BASE POSITION")){
                    sb.append(" #");
                    sb.append(line.substring(line.indexOf(':') + 1));

                    //System.out.println(sb.toString());
                    listString.add(sb.toString());

                    sb.delete(0,sb.length());
                    flag = false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listString;
    }

    public static void writeToFile(String path,List<String> listString){
        File file = new File(path);
        if (file.exists()){
            file.delete();
        }

        try{
            file.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }

        PrintStream printStream = null;
        try{
            printStream = new PrintStream(file);
            for (String s : listString) {
                printStream.println(s);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                printStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
