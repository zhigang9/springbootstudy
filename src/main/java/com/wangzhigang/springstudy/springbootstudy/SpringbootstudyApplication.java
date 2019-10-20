package com.wangzhigang.springstudy.springbootstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@RequestMapping(value="/a")
@RestController
@MapperScan(basePackages = "com.wangzhigang.springstudy.springbootstudy.interfaces")
public class SpringbootstudyApplication {

    @RequestMapping(value = "/b",method = RequestMethod.GET)
    public String hellospring(){
        return "hello-spring";
    }

    public static void main(String[] args) throws Exception {


        List<Person> personList = new ArrayList<>();

        Person a = new Person();
        a.setId(1);
        a.setName("a");
        a.setAddress("aaaaaaaaaa");

        Person b = new Person();
        b.setId(2);
        b.setName("b");
        b.setAddress("bbbbbbbbbb");

        Person d = new Person();
        d.setId(3);
        d.setName("b");
        d.setAddress("ccccccccccc");

        personList.add(a);
        personList.add(b);
        personList.add(d);

        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(c -> c.getName()));
        System.out.println(collect);

        for(List<Person> personList23 : collect.values())
        {
            if(personList23.size() > 1)
                System.out.println(personList23.get(1).getName());
        }

        SpringApplication.run(SpringbootstudyApplication.class, args);

    }

}


class Person {

    private int id;
    private String name;
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

