package com.wangzhigang.springstudy.springbootstudy.service;

import com.wangzhigang.springstudy.springbootstudy.interfaces.UserInfoMapper;
import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public void createUser(String tel,String pwd){
        userInfoMapper.createUser(tel,pwd);
    }

    public UserInfo getUser(Integer id){

        return userInfoMapper.getUser(id);
    }

    public int updateUser(String user_id,String nickName)

    {
        return userInfoMapper.updateUser(user_id,nickName);
    }

    public void deleteUser(Integer id){

        userInfoMapper.deleteUser(id);
    }
}
