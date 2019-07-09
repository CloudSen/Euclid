package com.collapseunion.commonutils.globalresult;

import org.springframework.http.HttpStatus;

/**
 * 统一结果返回工具类
 *
 * @author CloudSen
 */
public class ResultUtil {

    /*==============处理成功===============*/

    public static <T> Result<T> ok(String provider) {
        return new Result<>(Boolean.TRUE, String.valueOf(HttpStatus.OK.value()), "OK", provider);
    }

    public static <T> Result<T> ok(String message, String provider) {
        return new Result<>(Boolean.TRUE, String.valueOf(HttpStatus.OK.value()), message, provider);
    }

    public static <T> Result<T> ok(String message, String code, String provider) {
        return new Result<>(Boolean.TRUE, code, message, provider);
    }

    public static <T> Result<T> ok(T data, String provider) {
        return new Result<>(Boolean.TRUE, data, String.valueOf(HttpStatus.OK.value()), provider, "OK");
    }

    public static <T> Result<T> ok(T data, String message, String provider) {
        return new Result<>(Boolean.TRUE, data, String.valueOf(HttpStatus.OK.value()), provider, message);
    }

    public static <T> Result<T> ok(T data, String message, String code, String provider) {
        return new Result<>(Boolean.TRUE, data, code, provider, message);
    }

    /*==============处理失败===============*/

    public static <T> Result<T> failed(String provider) {
        return new Result<>(Boolean.FALSE, String.valueOf(ResultCode.FAILED_TO_HANDLE.getCode()), "FAILED", provider);
    }

    public static <T> Result<T> failed(String message, String provider) {
        return new Result<>(Boolean.FALSE, String.valueOf(ResultCode.FAILED_TO_HANDLE.getCode()), message, provider);
    }

    public static <T> Result<T> failed(String message, String code, String provider) {
        return new Result<>(Boolean.FALSE, code, message, provider);
    }

    public static <T> Result<T> failed(T data, String provider) {
        return new Result<>(Boolean.FALSE, data, String.valueOf(ResultCode.FAILED_TO_HANDLE.getCode()), provider, "FAILED");
    }

    public static <T> Result<T> failed(T data, String message, String provider) {
        return new Result<>(Boolean.FALSE, data, String.valueOf(ResultCode.FAILED_TO_HANDLE.getCode()), provider, message);
    }

    public static <T> Result<T> failed(T data, String message, String code, String provider) {
        return new Result<>(Boolean.FALSE, data, code, provider, message);
    }

    /*==============处理异常===============*/

    public static <T> Result<T> error(String provider) {
        return new Result<>(Boolean.FALSE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "ERROR", provider);
    }

    public static <T> Result<T> error(String message, String provider) {
        return new Result<>(Boolean.FALSE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), message, provider);
    }

    public static <T> Result<T> error(String message, String code, String provider) {
        return new Result<>(Boolean.FALSE, code, message, provider);
    }

    public static <T> Result<T> error(T data, String provider) {
        return new Result<>(Boolean.FALSE, data, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), provider, "ERROR");
    }

    public static <T> Result<T> error(T data, String message, String provider) {
        return new Result<>(Boolean.FALSE, data, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), provider, message);
    }

    public static <T> Result<T> error(T data, String message, String code, String provider) {
        return new Result<>(Boolean.FALSE, data, code, provider, message);
    }
}
