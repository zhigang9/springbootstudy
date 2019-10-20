package com.wangzhigang.springstudy.springbootstudy.interfaces;

import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface MybatisUserXMLMapper {
    void createUser(Map<String,Object> user);

    UserInfo getUser(@Param("id") Integer id);

    void updateUser(@Param("user_id") String user_id,@Param("nickName") String nickName);

    void deleteUserByUserId(UserInfo userInfo);
}
