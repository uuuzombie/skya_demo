package com.sky.demo.common.reflect.bean;


public class VipUser extends User {

    private Integer vipNum;

    public VipUser() {
    }

    public VipUser(Long id, String name, Integer age, String address, Integer vipNum) {
        super(id, name, age, address);
        this.vipNum = vipNum;
    }

    public VipUser(Long id, String name, Integer age, String address, Integer sex, Integer cname, Integer vipNum) {
        super(id, name, age, address, sex, cname);
        this.vipNum = vipNum;
    }

    public Integer getVipNum() {
        return vipNum;
    }

    public void setVipNum(Integer vipNum) {
        this.vipNum = vipNum;
    }
}
