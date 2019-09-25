package com.wangzhigang.springstudy.springbootstudy.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

public class UserInfo {

    public UserInfo() {
    }

    private Integer user_id;

    private String tel;

    @Min(value = 000000,message = "密码不能小于000000")
    @Max(value = 999999,message = "密码不能大于999999")
    private String password;

    private String nickname;

    private String secret;

    private String portrait;

    private String i_card;

    private int area;

    private Date create_time;

    private Date update_time;


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getI_card() {
        return i_card;
    }

    public void setI_card(String i_card) {
        this.i_card = i_card;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
