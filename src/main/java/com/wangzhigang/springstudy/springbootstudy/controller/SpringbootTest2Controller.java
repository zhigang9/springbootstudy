package com.wangzhigang.springstudy.springbootstudy.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

//1.如果访问springboot的程序报404，可能是未加RequestMapping，类需要增加，方法同样需要增加
@RequestMapping(value = "/test2")
@RestController
public class SpringbootTest2Controller {

    @RequestMapping(method = RequestMethod.GET,value = "/test22")
    public String test22(){
        return "test22";
    }
}
