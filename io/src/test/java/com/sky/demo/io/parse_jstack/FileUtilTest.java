package com.sky.demo.io.parse_jstack;

import com.google.common.collect.Multimap;
import com.sky.demo.io.parse_jstack.handler.impl.ThreadProcImpl;
import com.sky.demo.io.parse_jstack.model.ConditionInfo;
import com.sky.demo.io.parse_jstack.util.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by rg on 15/6/28.
 */
public class FileUtilTest {

    private static final String INPUT_FILE = "/j.stack";
    private static final String OUTPUT_FILE = "/result.txt";

    ThreadProcImpl threadProcImpl = new ThreadProcImpl();

    @Before
    public void setUp(){

    }

    @Test
    public void test_ParseJsatck() throws IOException {

        List<String> listStrings = FileUtil.readFile(INPUT_FILE);
        //System.out.println(listStrings);

        Multimap<String, String> map = threadProcImpl.process(listStrings);

        List<ConditionInfo> listConditionInfos = threadProcImpl.sort(map);
        System.out.println(listConditionInfos);

        FileUtil.outputResult(map, listConditionInfos, OUTPUT_FILE);
    }
}
