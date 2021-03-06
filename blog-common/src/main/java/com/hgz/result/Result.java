package com.hgz.result;

import lombok.Data;


public class Result<T> {

    public String code;

    private String message;

    private boolean flag;

    private T data;


    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isFlag() {
        return flag;
    }

    public Result<T> setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }
}
