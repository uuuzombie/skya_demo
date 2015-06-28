package com.sky.demo.io.parse_jstack.handler;

import com.google.common.collect.Multimap;
import com.sky.demo.io.parse_jstack.model.ConditionInfo;

import java.util.List;

/**
 * Created by rg on 15/6/28.
 */
public interface ThreadProc {

    /**
     * 处理字符串，从中选出conditionId、threadId、threadName,threadState等信息
     * 并将这些信息加入到Multimap中。
     *
     * @param listStrings 输入字符串链表
     * @return 返回处理后的信息
     */
    public Multimap<String, String> process(List<String> listStrings);

    public String parseConditionId(String line);

    public String parseThreadId(String line);

    public String parseThreadName(String line);

    public String parseThreadState(String line);

    public List<ConditionInfo> sort(Multimap<String, String> map);
}
