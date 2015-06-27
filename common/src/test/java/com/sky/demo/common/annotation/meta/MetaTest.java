package com.sky.demo.common.annotation.meta;

import com.sky.demo.common.annotation.meta.apply.Meta;
import org.junit.Test;

/**
 * Created by rg on 15/6/27.
 */
public class MetaTest {

    @Test
    public void test_myMeth(){
        Meta.myMeth();
        Meta.myMeth("Two", 22);
    }
}
