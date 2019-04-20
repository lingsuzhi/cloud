package com.lsz.cloud.busioness.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ManDTO {

    @ApiModelProperty("姓名")
    private String name ;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("生日")
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
