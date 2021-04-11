package com.hgz.result;
public class ResultResponse {

    private final static String SUCCESS = "success";

    public static <T> Result<T> makeOKRsp() {
        return new Result<T>().setCode(ResultCode.SUCCESS.getCode()).setMessage(SUCCESS).setFlag(true);
    }

    public static <T> Result<T> makeOKRsp(T data) {
        return new Result<T>().setCode(ResultCode.SUCCESS.getCode()).setMessage(SUCCESS).setData(data).setFlag(true);
    }

    public static <T> Result<T> makeErrRsp(String message) {
        return new Result<T>().setCode(ResultCode.FAIL.getCode()).setMessage(message);
    }

    public static <T> Result<T> makeRsp(String code, String message) {
        return new Result<T>().setCode(code).setMessage(message);
    }

    public static <T> Result<T> makeRsp(String code, String message, T data) {
        return new Result<T>().setCode(code).setMessage(message).setData(data);
    }
}
