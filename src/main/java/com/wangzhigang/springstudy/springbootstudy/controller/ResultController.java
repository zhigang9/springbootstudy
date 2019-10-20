package com.wangzhigang.springstudy.springbootstudy.controller;

import com.wangzhigang.springstudy.springbootstudy.enums.ExceptionEnum;
import com.wangzhigang.springstudy.springbootstudy.exceptions.ExceptionHandle;
import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import com.wangzhigang.springstudy.springbootstudy.response.Result;
import com.wangzhigang.springstudy.springbootstudy.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ExceptionHandle exceptionHandle;

    @RequestMapping(value = "/getresult",method = RequestMethod.POST)
    public Result getResult(@RequestParam("name") String name,@RequestParam("pwd") String pwd){

        Result result = ResultUtils.error(ExceptionEnum.UNKNOW_ERROR);


        try {
            if(name.equals("wangzhigang")){

                result = ResultUtils.success(new UserInfo());
            }
            else if(name.equals("wzg")){
                result = ResultUtils.error(ExceptionEnum.USER_NOT_FIND);
            }
            else{
                int i = 1/0;
            }
        } catch (Exception e) {

            result = exceptionHandle.exceptionGet(e);
        }

        return  result;
    }
}
