package com.collapseunion.globalresult;

import org.springframework.http.HttpStatus;

/**
 * 统一结果返回工具类
 *
 * @author CloudSen
 */
public class ResultUtil {

    /*==============处理成功===============*/

    public static <T> Result<T> ok() {
        return new Result<>(Boolean.TRUE, String.valueOf(HttpStatus.OK.value()), "OK");
    }

    public static <T> Result<T> ok(String message) {
        return new Result<>(Boolean.TRUE, String.valueOf(HttpStatus.OK.value()), message);
    }

    public static <T> Result<T> ok(String message, String code) {
        return new Result<>(Boolean.TRUE, code, message);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(Boolean.TRUE, data, String.valueOf(HttpStatus.OK.value()), "OK");
    }

    public static <T> Result<T> ok(T data, String message) {
        return new Result<>(Boolean.TRUE, data, String.valueOf(HttpStatus.OK.value()), message);
    }

    public static <T> Result<T> ok(T data, String message, String code) {
        return new Result<>(Boolean.TRUE, data, code, message);
    }

    /*==============处理失败===============*/

    public static <T> Result<T> failed() {
        return new Result<>(Boolean.FALSE, String.valueOf(ResultCode.FAILED_TO_HANDLE.getCode()), "FAILED");
    }

    public static <T> Result<T> failed(String message) {
        return new Result<>(Boolean.FALSE, String.valueOf(ResultCode.FAILED_TO_HANDLE.getCode()), message);
    }

    public static <T> Result<T> failed(String message, String code) {
        return new Result<>(Boolean.FALSE, code, message);
    }

    public static <T> Result<T> failed(T data) {
        return new Result<>(Boolean.FALSE, data, String.valueOf(ResultCode.FAILED_TO_HANDLE.getCode()), "FAILED");
    }

    public static <T> Result<T> failed(T data, String message) {
        return new Result<>(Boolean.FALSE, data, String.valueOf(ResultCode.FAILED_TO_HANDLE.getCode()), message);
    }

    public static <T> Result<T> failed(T data, String message, String code) {
        return new Result<>(Boolean.FALSE, data, code, message);
    }

    /*==============处理异常===============*/

    public static <T> Result<T> error() {
        return new Result<>(Boolean.FALSE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "ERROR");
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(Boolean.FALSE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), message);
    }

    public static <T> Result<T> error(String message, String code) {
        return new Result<>(Boolean.FALSE, code, message);
    }

    public static <T> Result<T> error(T data) {
        return new Result<>(Boolean.FALSE, data, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "ERROR");
    }

    public static <T> Result<T> error(T data, String message) {
        return new Result<>(Boolean.FALSE, data, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), message);
    }

    public static <T> Result<T> error(T data, String message, String code) {
        return new Result<>(Boolean.FALSE, data, code, message);
    }
}
