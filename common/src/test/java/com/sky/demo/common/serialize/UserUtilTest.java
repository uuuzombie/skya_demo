package com.sky.demo.common.serialize;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sky.demo.common.serialize.bean.Address;
import com.sky.demo.common.serialize.bean.DetailAddress;
import com.sky.demo.common.serialize.bean.User;
import com.sky.demo.common.serialize.util.UserUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by rg on 15/6/27.
 */
public class UserUtilTest {

    List<User> friends = Lists.newArrayList();

    private static String FILE_PATH = "../1.txt";

    @Before
    public void setUp(){

        for (int i = 0;i < 3;++i){
            User user = new User("a" + i,10 + i,1234567 + i);
            friends.add(user);
        }

    }


    @Test
    public void test_writeToFile(){

        //User user = new User("aa",10,1234567,friends);

        Address address = new DetailAddress("aa","bb","cc");
        Map<String,Address> map = Maps.newHashMap();
        map.put("aa",address);

        User user = new User("aa",10,1234567,map);
        UserUtil.writeToFile(user, FILE_PATH);
    }

    @Test
    public void test_readFromFile(){

        //在从流文件中读取数据，反序列化时，如果不设置UID，则会抛异常
        //如果设置UID，则在反序列化时，以前的流也能正常反序列化，但是新的字段是默认值
        //并且，如果字段是Map，则类型也必须序列化

        User user = UserUtil.readFromFile(FILE_PATH);
        System.out.println(user);

    }
}
