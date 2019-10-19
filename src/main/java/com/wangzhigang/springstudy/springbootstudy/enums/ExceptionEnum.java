package com.wangzhigang.springstudy.springbootstudy.enums;

public enum ExceptionEnum{

    UNKNOW_ERROR(-1,"未知错误"),
    USER_NOT_FIND(-101,"用户信息错误"),
    NULL_POINT_EXCEPTION(-102,"空指针异常");

    private int code;
    private String msg;

    ExceptionEnum(int _code, String _msg) {
        this.code = _code;
        this.msg = _msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
