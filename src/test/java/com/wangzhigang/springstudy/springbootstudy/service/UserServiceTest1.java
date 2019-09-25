package com.wangzhigang.springstudy.springbootstudy.service;

import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest1 {

    @Autowired
    private UserService userService;

    @Test
    public void createUser() {
    }

    @Test
    public void getUser() {

        UserInfo userInfo = userService.getUser(238);

        if(userInfo != null) {
            System.out.println(userInfo.getNickname());
            System.out.println(userInfo.getUser_id());
        }
    }

    @Test
    public void updateUser() {
        userService.updateUser("238","123456789");
        this.getUser();
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(238);
        this.getUser();
    }
}