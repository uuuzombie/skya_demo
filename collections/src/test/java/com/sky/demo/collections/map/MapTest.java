package com.sky.demo.collections.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sky.demo.collections.model.User;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by rg on 2015/6/23.
 */
public class MapTest {
    Map<String,Object> map = Maps.newHashMap();

    @Before
    public void setUp(){
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
    }

    @Test
    public void test_Map_put(){
        Map<String,Object> map = Maps.newHashMap();

        List<Object> objectList = Lists.newArrayList();
        map.put("aaa",objectList);
        System.out.println(map);

        objectList.add(1);
        System.out.println(map);
    }

    @Test
    public void test_Map_change_value(){
        User user = new User(1,"xiaoming");
        System.out.println(user);

        Map<String, String> map = user.getRelation();
        map.put("aa","aa");
        map.put("bb","bb");
        System.out.println(user);
    }

    @Test
    public void test_Map_entrySet_iterator(){

        System.out.println(map);
        System.out.println(map.entrySet());

        System.out.println(map.entrySet().iterator().next()); //返回迭代器刚越过的元素的引用
        System.out.println(map.entrySet().iterator().next().getKey());

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test_Map_User_null(){

        User user = new User();
        System.out.println(user);

        if (null == user.getRelation()){
            user.setRelation(new HashMap<String, String>());
        }

        System.out.println(user);
        System.out.println(user.getRelation().size());
    }

    @Test
    public void test_Map_Key_Not_exist_should_return_NULL(){

        Map<String,String> map = Maps.newHashMap();

        String str = map.get("aaa");
        System.out.println(str);

        assertTrue(str == null);
    }


    @Test
    public void test_Map_toString(){

        Set<String> cabins = Sets.newHashSet();
        cabins.add("Y");
        cabins.add("X");


        Map<String,Map<String,Integer>> avSeat = Maps.newHashMap();

        Map<String,Integer> map1 = Maps.newHashMap();
        map1.put("A",7);
        map1.put("B",8);
        map1.put("C",9);
        map1.put("D",2);
        map1.put("Y",7);
        avSeat.put("map1",map1);

        Map<String,Integer> map2 = Maps.newHashMap();
        map2.put("T",2);
        map2.put("C",3);
        avSeat.put("map2",map2);

        System.out.println(avSeat);
        System.out.println(avSeat.toString());
        int matchCount = 0;
        for (Map.Entry<String,Map<String,Integer>> entry : avSeat.entrySet()) {
            System.out.print(entry.getKey() + ":{");
            int match = 0;
            for (Map.Entry<String,Integer> en : entry.getValue().entrySet()) {
                //System.out.println(en.getKey() + ":" + en.getValue());
                if (cabins.contains(en.getKey())){
                    System.out.print(en.getKey() + en.getValue());
                    match++;
                }
            }
            System.out.print("},");
            matchCount = matchCount > match ? matchCount : match;
        }

        System.out.println(matchCount);

    }


    @Test
    public void test_Map_Cabin(){

        Map<String,String> cabins = Maps.newHashMap();

        cabins.put("MU345","Y");
        cabins.put("CA111","B");
        cabins.put("CA112","A");
        cabins.put("CA113","C");

        System.out.println("cabin:" + cabins);

        Map<String,Map<String,Integer>> avSeat = Maps.newHashMap();

        Map<String,Integer> map1 = Maps.newHashMap();
        map1.put("A",7);
        map1.put("B",8);
        map1.put("C",9);
        map1.put("D",2);
        map1.put("Y",7);
        avSeat.put("MU345",map1);

        Map<String,Integer> map2 = Maps.newHashMap();
        map2.put("Y",2);
        map2.put("C",3);
        avSeat.put("CA111",map2);

        Map<String,Integer> map3 = Maps.newHashMap();
        map3.put("Y",2);
        map3.put("C",3);
        avSeat.put("CA112",map3);

        Map<String,Integer> map4 = Maps.newHashMap();
        map4.put("Y",2);
        map4.put("C",3);
        avSeat.put("CA113",map4);

        System.out.println("avSeat:" + avSeat);

        StringBuilder sb = new StringBuilder();
        int matchCount = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : avSeat.entrySet()) {
            sb.append(entry.getKey()).append(":{");
            for (Map.Entry<String,String> cb : cabins.entrySet()) {
                if (StringUtils.equals(cb.getKey(), entry.getKey())){
                    for (Map.Entry<String,Integer> en :entry.getValue().entrySet()){
                        if (StringUtils.equals(cb.getValue(),en.getKey()) && en.getValue() > 0){
                            sb.append(en.getKey()).append(en.getValue());
                            matchCount++;
                        }
                    }
                }
            }
            sb.append("},");
        }
        System.out.println(matchCount);

        System.out.println(sb.toString());

    }

    @Test
    public void test_Map_put_reput(){
        Map<String,Integer> map1 = Maps.newHashMap();

        map1.put("AA",1);
        map1.put("BB",2);
        System.out.println(map1);

        map1.put("AA",33);
        System.out.println(map1);

    }

    @Test
    public void test_Map_size_when_null(){
        //Map<String,Object> map1 = null;
        Map<String,Object> map2 = Maps.newHashMap();

        //System.out.println(map1.size());     //throw NPE
        System.out.println(map2.size());     //0
    }

    @Test
    public void test_MapUtils_is_empty(){

        Map<String,Object> map1 = null;
        Map<String,Object> map2 = Maps.newHashMap();

        System.out.println(MapUtils.isEmpty(map1));
        System.out.println(MapUtils.isEmpty(map2));

    }
}
