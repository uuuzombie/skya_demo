package com.sky.demo.io.count_character.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.sky.demo.io.count_character.action.DigitCharCounter;
import com.sky.demo.io.count_character.action.LetterCharCounter;
import com.sky.demo.io.count_character.action.SpaceCharCounter;
import com.sky.demo.io.count_character.action.TotalLineCounter;
import com.sky.demo.io.count_character.service.CharCounter;
import com.sky.demo.io.count_character.service.LineCounter;
import com.sky.demo.io.count_character.service.Reportable;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * Created by rg on 15/6/27.
 */
public class FileOpt {

    public static List<Reportable> readFile(String path) throws IOException {

        URL resource = FileOpt.class.getResource(path);
        Preconditions.checkNotNull(resource);

        File inputFile = new File(resource.getFile());
        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        List<CharCounter> listCharCounter = Lists.newArrayList();
        listCharCounter.add(new DigitCharCounter());
        listCharCounter.add(new SpaceCharCounter());
        listCharCounter.add(new LetterCharCounter());

        List<LineCounter> listLineCounter = Lists.newArrayList();
        listLineCounter.add(new TotalLineCounter());

        List<Reportable> reportables = getReportables(inputFile, listLineCounter, listCharCounter);

        return reportables;
    }

    public static void writeFile(List<Reportable> reportables, String path) throws IOException {

        URL resource = FileOpt.class.getResource(path);
        Preconditions.checkNotNull(resource);

        File outputFile = new File(resource.getFile());
        if (outputFile.exists()) {
            outputFile.delete();
        }
        if (!outputFile.createNewFile()) {
            throw new RuntimeException("can not create file");
        }

        PrintStream printStream = null;
        try {
            printStream = new PrintStream(outputFile);

            for (Reportable reportable : reportables) {
                if (reportable.getSummary() != null) {
                    printStream.println(reportable.getSummary());
                }
            }
            printStream.println();
            for (Reportable reportable : reportables) {
                if (reportable.getDetail() != null) {
                    printStream.println(reportable.getDetail());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }

    }

    private static List<Reportable> getReportables(File file, List<LineCounter> lineCounters, List<CharCounter> charCounters) throws IOException {

        List<Reportable> reportables = Lists.newArrayList();
        reportables.addAll(lineCounters);
        reportables.addAll(charCounters);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));

            String line;
            while ((line = br.readLine()) != null) {
                for (LineCounter lineCounter : lineCounters) {
                    lineCounter.count(line);
                }

                char[] chars = line.toCharArray();
                for (char aChar : chars) {
                    for (CharCounter counter : charCounters) {
                        counter.count(aChar);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return reportables;
    }
}
