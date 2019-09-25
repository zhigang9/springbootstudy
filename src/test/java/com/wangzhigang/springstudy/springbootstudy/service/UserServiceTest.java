package com.wangzhigang.springstudy.springbootstudy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUser() throws Exception{

        userService.createUser("13621294329","12346");
        userService.createUser("13621294328","12346");
        userService.createUser("13621294327","12346");
        userService.createUser("13621294326","12346");
        userService.createUser("13621294325","12346");
    }
}
