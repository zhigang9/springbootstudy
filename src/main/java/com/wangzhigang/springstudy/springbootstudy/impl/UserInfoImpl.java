package com.wangzhigang.springstudy.springbootstudy.impl;

import com.wangzhigang.springstudy.springbootstudy.interfaces.UserInfoMapper;
import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserInfoImpl implements UserInfoMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createUser(String tel, String pwd) {
        jdbcTemplate.update("insert into mysql_test_db.tp_user (tel,password,nickname,secret) VALUES (?,md5(?),?,'')",tel,pwd,tel);

    }

    @Override
    public UserInfo getUser(Integer id) {

        List<UserInfo> userInfoList = jdbcTemplate.query("select user_id, tel,nickname,password FROM mysql_test_db.tp_user WHERE user_id = ?",new Object[]{id},new BeanPropertyRowMapper(UserInfo.class));

        if(userInfoList != null && userInfoList.size() > 0){

            UserInfo userInfo = userInfoList.get(0);

            return userInfo;
        }
        else
            return null;
    }


    @Override
    public int updateUser(String userId,String nickName) {

        jdbcTemplate.update("UPDATE mysql_test_db.tp_user SET nickname = ? WHERE user_id = ?",nickName,userId);

        return 1;
    }

    @Override
    public void deleteUser(Integer id) {

        jdbcTemplate.update("DELETE FROM mysql_test_db.tp_user WHERE user_id = ?",id);
    }
}
