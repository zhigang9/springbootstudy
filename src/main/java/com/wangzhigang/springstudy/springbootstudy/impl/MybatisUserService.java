package com.wangzhigang.springstudy.springbootstudy.impl;

import com.wangzhigang.springstudy.springbootstudy.interfaces.MybatisUserAnnotaionMapper;
import com.wangzhigang.springstudy.springbootstudy.interfaces.MybatisUserXMLMapper;
import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class MybatisUserService {

    @Autowired
    private MybatisUserXMLMapper annotaionMapper;

    public void createUser(Map<String,Object> map){

        annotaionMapper.createUser(map);

    }

    public void updateUser(String user_id,String nickName){
        annotaionMapper.updateUser(user_id,nickName);
    }

    public UserInfo getUser(Integer user_id){

        return annotaionMapper.getUser(user_id);
    }

    public void deleteUserByUserId(UserInfo userInfo){

        annotaionMapper.deleteUserByUserId(userInfo);
    }
}
