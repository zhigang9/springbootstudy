package com.wangzhigang.springstudy.springbootstudy.exceptions;


import com.wangzhigang.springstudy.springbootstudy.enums.ExceptionEnum;

public class DescribeException extends RuntimeException {

    private Integer code;

    /*
    继承RuntimeException
     */
    public DescribeException(ExceptionEnum exceptionEnum){

        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }


    public DescribeException(String message,Integer code){
        super(message);
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
