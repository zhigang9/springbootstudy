package com.wangzhigang.springstudy.springbootstudy.controller;

import com.wangzhigang.springstudy.springbootstudy.enums.ExceptionEnum;
import com.wangzhigang.springstudy.springbootstudy.exceptions.ExceptionHandle;
import com.wangzhigang.springstudy.springbootstudy.impl.MybatisUserService;
import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import com.wangzhigang.springstudy.springbootstudy.utils.ResultUtils;
import org.apache.ibatis.annotations.Delete;
import com.wangzhigang.springstudy.springbootstudy.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private MybatisUserService mybatisUserService;

    @Autowired
    private ExceptionHandle exceptionHandle;

    //@PostMapping(value = "/createuserbymap")
    @RequestMapping(value = "/createuserbymap",method = RequestMethod.POST)
    public Result createUser(@RequestBody Map<String,Object> map){

        Result result = ResultUtils.success();
        try {
            mybatisUserService.createUser(map);
        } catch (Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }

        return result;
    }

    @PutMapping(value = "/updateuser/{id}")
    public Result updateUser(@PathVariable("id") String user_id,@RequestParam("nickName") String nickName){

        Result result = ResultUtils.success();
        try {
            mybatisUserService.updateUser(user_id,nickName);
        } catch (Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }

        return result;
    }

    @GetMapping(value = "/getuser/{id}")
    public Result getUser(@PathVariable("id") Integer user_id){

        Result result = ResultUtils.error(ExceptionEnum.UNKNOW_ERROR);

        try {
            UserInfo userInfo = mybatisUserService.getUser(user_id);
            result = ResultUtils.success(userInfo);
        } catch (Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }

        return result;
    }

    @DeleteMapping("/deleteuserbyid/{tel}")
    public Result deleteUser(@PathVariable("tel") String tel){

        Result result = ResultUtils.success();
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setTel(tel);
            mybatisUserService.deleteUserByUserId(userInfo);
        } catch (Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }
}
