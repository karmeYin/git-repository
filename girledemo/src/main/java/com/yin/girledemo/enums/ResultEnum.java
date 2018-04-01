package com.yin.girledemo.enums;


public enum  ResultEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCES(000000,"成功"),
    PRIMARY_SCHOOL(000001,"你可能还在上小学吧"),
    MIDDLE_SCHOOL(000002,"你可能还在上高中吧");

    private Integer code;

    private String msg;

     ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
