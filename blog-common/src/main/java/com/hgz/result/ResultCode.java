package com.hgz.result;


public enum  ResultCode {

    SUCCESS("200","success"),

    FAIL("400","fail"),

    UNAUTHORIZED("401","未认证签名错误"),

    NOT_FOUND("404","接口不存在"),

    INTERNAL_SERVER_ERROR("500","服务器内部错误");

    private String code;

    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
