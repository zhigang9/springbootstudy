package com.wangzhigang.springstudy.springbootstudy.exceptions;


import com.wangzhigang.springstudy.springbootstudy.enums.ExceptionEnum;
import com.wangzhigang.springstudy.springbootstudy.response.Result;
import com.wangzhigang.springstudy.springbootstudy.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e){

        LOGGER.info("msg = " + e.getMessage());

        if(e instanceof DescribeException) {
            DescribeException myException = (DescribeException) e;
            return ResultUtils.error(myException.getCode(), myException.getMessage());

        }

        return ResultUtils.error(ExceptionEnum.UNKNOW_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public Result exceptionGet(NullPointerException ex){

        if(ex instanceof NullPointerException){

            return  ResultUtils.error(ExceptionEnum.NULL_POINT_EXCEPTION);
        }

        return ResultUtils.error(ExceptionEnum.UNKNOW_ERROR);
    }
}
