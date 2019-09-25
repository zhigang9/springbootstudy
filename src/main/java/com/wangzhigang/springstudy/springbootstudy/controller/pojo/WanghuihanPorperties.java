package com.wangzhigang.springstudy.springbootstudy.controller.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "wanghuihan")
public class WanghuihanPorperties {

    private Girl girl;

    public void setGirl(Girl g){girl = g;}
    public Girl getGirl(){return girl;}

    public String toString(){
        return girl.getName() + "\n" + girl.getAge();
    }
}

class Girl
{
    private String name;
    private Integer age;
    private String sex;

    public void setName(String n){name = n;}
    public String getName(){return name;}

    public void setAge(Integer a){age = a;}
    public Integer getAge(){return age;}

    public void setSex(String s){sex = s;}
    public String getSex(){return sex;}
}
