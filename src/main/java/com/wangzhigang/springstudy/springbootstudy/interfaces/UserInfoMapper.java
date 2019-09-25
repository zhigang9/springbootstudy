package com.wangzhigang.springstudy.springbootstudy.interfaces;

import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;

public interface UserInfoMapper {

    void createUser(String tel,String pwd);

    UserInfo getUser(Integer id);

    int updateUser(String userId,String nickName);

    void deleteUser(Integer id);
}
