package com.wangzhigang.springstudy.springbootstudy.interfaces;

import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface MybatisUserAnnotaionMapper {

   /* @Insert("insert into tp_user(tel,password,nickname,secret) values(#{tel},md5(#{pwd}),#{tel},'')")
    void createUser(Map<String,Object> user);

    @Select("select tel,nickname,password from tp_user where user_id = #{id}")
    UserInfo getUser(@Param("id") Integer id);

    @Update("update tp_user set nickname=#{nickName} where user_id = #{user_id}")
    void updateUser(@Param("user_id") String user_id,@Param("nickName") String nickName);

    @Delete("delete from tp_user where tel = #{tel}")
    void deleteUserByUserId(UserInfo userInfo);*/

}
