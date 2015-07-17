package com.sky.demo.common.reflet.field;

import com.sky.demo.common.reflect.field.FieldChangeInfo;
import com.sky.demo.common.reflect.field.ResourceItem;
import com.sky.demo.common.reflect.field.ResourceUtil;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;


import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by rg on 2015/7/16.
 */
public class ResourceUtilTest {

    @Test
    public void test_getResourceChangeInfo() {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        Time t1 = new Time(DateTime.parse("01:00", formatter).toLocalTime().toDateTimeToday().getMillis());
        Time t2 = new Time(DateTime.parse("01:00", formatter).toLocalTime().toDateTimeToday().getMillis());

        ResourceItem item1 = new ResourceItem(1,"name1",10,true,new Date(), t1);
        ResourceItem item2 = new ResourceItem(2,"name1",10,false,new Date(), t2);

        List<FieldChangeInfo> infos = ResourceUtil.getResourceChangeInfo(item1, item2, ResourceItem.class);

        System.out.println(infos);
    }
}
