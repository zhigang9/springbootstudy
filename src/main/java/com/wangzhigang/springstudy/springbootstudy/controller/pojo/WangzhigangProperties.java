package com.wangzhigang.springstudy.springbootstudy.controller.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//3.@Component注解可以保证pojo可以被spring注入；
@Component
//@ConfigurationProperties(prefix = “zzp”)注解来获取配置文件中前缀为zzp的配置，prefix指的是前缀
@ConfigurationProperties(prefix = "wangzhigang")
public class WangzhigangProperties {

    private String name;

    private String age;

    private String sex;

    public void setName(String name1){
        this.name = name1;
    }

    public String getName(){return this.name;}

    public void setSex(String s){this.sex = s;}

    public String getSex(){return this.sex;}

    public void setAge(String a){this.age = a;}

    public String getAge(){return this.age;}

    public String toString(){

        return name + "\n" + age + "\n" + sex;
    }
}
