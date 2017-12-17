package com.cowboy.comon.model.sys;

/**
 * Created by cowboy on 2017-12-17.
 * 系统响应码
 */
public enum CommonResultCode {
    SUCCESS("10200","成功"),
    FAIL("10201","处理失败"),
    LOGIN_CREDENTIALS_ERROR("20001","账号或者密码错误");

    private String code;
    private String desc;
    CommonResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
