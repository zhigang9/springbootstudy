package com.wangzhigang.springstudy.springbootstudy.controller;

import com.wangzhigang.springstudy.springbootstudy.controller.pojo.WanghuihanPorperties;
import com.wangzhigang.springstudy.springbootstudy.controller.pojo.WangzhigangProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/readconfig")
@RestController
public class ReadConfigValueController {

    //2.使用spring注解@Value("${节点名称}")读取application.properties文件节点内容
    @Value("${wanghuihan.girl.name}")
    private String Name;

    @Value("${wanghuihan.girl.age}")
    private String Age;

    @Value("${wanghuihan.girl.sex}")
    private String Sex;

    @Autowired
    private WangzhigangProperties wzgp;

    @Autowired
    private WanghuihanPorperties whhp;

    @RequestMapping(method = RequestMethod.GET,value = "/read")
    public String readConfig(){

        return Name + "\n" + Age + "\n" + Sex;
    }


    @RequestMapping(method = RequestMethod.GET,value = "/readconfigbyentry")
    public WangzhigangProperties readconfigByEntry(){

        return wzgp;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/readconfigbyentry2")
    public WanghuihanPorperties readconfigByentry2(){
        return whhp;
    }
}
