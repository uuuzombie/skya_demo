package com.sky.demo.io.parse_jstack.handler.impl;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Ints;
import com.sky.demo.io.parse_jstack.handler.ThreadProc;
import com.sky.demo.io.parse_jstack.model.ConditionInfo;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rg on 15/6/28.
 */
public class ThreadProcImpl implements ThreadProc {


    @Override
    public Multimap<String, String> process(List<String> listStrings) {
        Multimap<String, String> map = ArrayListMultimap.create();

        for (String line : listStrings) {
            List<String> tempList = new ArrayList<String>();
            tempList.add(parseThreadId(line));
            tempList.add(parseThreadName(line));
            tempList.add(parseThreadState(line));

            String temp = Joiner.on("|").join(tempList);
            map.put(parseConditionId(line), temp);
        }
        return map;
    }

    @Override
    public String parseConditionId(String line) {
        String conditionId;

        int index1 = line.lastIndexOf('[');
        int index2 = line.lastIndexOf(']');
        if(index1 != -1 && index2 != -1){
            conditionId = line.substring(index1 + 1,index2);
        } else{
            conditionId = "";
        }
        return conditionId;
    }

    @Override
    public String parseThreadId(String line) {
        int index = line.indexOf("tid=");
        String threadId  = line.substring(index + 4,index + 4 + 18);
        return threadId;
    }

    @Override
    public String parseThreadName(String line) {
        String regxThreadName =  "\".+\"";
        String threadName;

        Pattern pattern = Pattern.compile(regxThreadName);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            threadName = CharMatcher.is('"').removeFrom(matcher.group(0));
        } else{
            threadName = "";
        }
        return threadName;
    }

    @Override
    public String parseThreadState(String line) {
        String threadState;
        int index = line.lastIndexOf(':');
        if (index != -1) {
            threadState = line.substring(index + 2);
        } else {
            threadState = "";
        }
        return threadState;
    }

    @Override
    public List<ConditionInfo> sort(Multimap<String, String> map) {
        List<ConditionInfo> listConditionInfos = new ArrayList<ConditionInfo>();
        Map<String, Collection<String>> map2 = map.asMap();

        //从map中读取信息存放到listConditionInfos中
        for (Map.Entry<String, Collection<String>> entry : map2.entrySet()) {

            String key = entry.getKey();
            ConditionInfo conditionInfo = new ConditionInfo(key, entry.getValue().size());
            listConditionInfos.add(conditionInfo);
        }

        //排序
        Collections.sort(listConditionInfos, new Comparator<ConditionInfo>() {
            //倒序
            @Override
            public int compare(ConditionInfo o1, ConditionInfo o2) {
                return -Ints.compare(o1.getCount(), o2.getCount());
            }
        });

        return listConditionInfos;
    }
}
