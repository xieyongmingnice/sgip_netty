package com.xunyu.sgip.dto;

import java.io.Serializable;

public class Bind extends SGIPCommend implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1621932244275557555L;
    private Integer LoginType;//登录类型
    private String LoginName;//登录账号
    private String LoginPassowrd;
    private String Reserve;//扩展用
    private byte[] LoginTypeByte;


    public byte[] getLoginTypeByte() {
        return LoginTypeByte;
    }

    public void setLoginTypeByte(byte[] loginTypeByte) {
        LoginTypeByte = loginTypeByte;
    }

    public Integer getLoginType() {
        return LoginType;
    }

    public void setLoginType(Integer loginType) {
        LoginType = loginType;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getLoginPassowrd() {
        return LoginPassowrd;
    }

    public void setLoginPassowrd(String loginPassowrd) {
        LoginPassowrd = loginPassowrd;
    }

    public String getReserve() {
        return Reserve;
    }

    public void setReserve(String reserve) {
        Reserve = reserve;
    }


}
