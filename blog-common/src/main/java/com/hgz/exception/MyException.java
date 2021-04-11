package com.hgz.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException{

    //错误码
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    public MyException(String code,String msg){
        this.code=code;
        this.msg=msg;
    }


}
