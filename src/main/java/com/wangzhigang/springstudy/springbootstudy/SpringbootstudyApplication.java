package com.wangzhigang.springstudy.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequestMapping(value="/a")
@RestController
public class SpringbootstudyApplication {

    @RequestMapping(value = "/b",method = RequestMethod.GET)
    public String hellospring(){
        return "hello-spring";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootstudyApplication.class, args);
    }

}
