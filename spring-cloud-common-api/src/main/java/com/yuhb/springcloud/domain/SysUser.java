package com.yuhb.springcloud.domain;

public class SysUser {
    /**
     *
     */
    private Integer id;

    /**
     *  姓名
     */
    private String name;

    /**
     *  性别（1-男 0-女）
     */
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
