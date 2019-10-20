package com.wangzhigang.springstudy.springbootstudy.globaldata;

import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyqGlobalData {

    @ModelAttribute(name="md")
    public Map<String,Object> getData(){

        HashMap<String,Object> map = new HashMap<>();
        map.put("age","39");
        map.put("name","wangzhigang");

        return map;
    }
}
