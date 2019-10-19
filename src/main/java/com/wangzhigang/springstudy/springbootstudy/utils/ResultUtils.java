package com.wangzhigang.springstudy.springbootstudy.utils;

import com.wangzhigang.springstudy.springbootstudy.enums.ExceptionEnum;
import com.wangzhigang.springstudy.springbootstudy.response.Result;

public class ResultUtils {

    public static Result success(Object object){
        Result result = new Result();
        result.setMsg("success");
        result.setStatus(0);
        result.setData(object);

        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(ExceptionEnum exceptionEnum){
        Result result = new Result();
        result.setData(null);
        result.setMsg(exceptionEnum.getMsg());
        result.setStatus(exceptionEnum.getCode());

        return result;
    }

    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setStatus(code);
        result.setMsg(message);
        result.setData(null);

        return result;
    }


}
