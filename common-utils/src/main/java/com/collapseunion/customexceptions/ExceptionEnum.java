package com.collapseunion.customexceptions;

import com.collapseunion.globalresult.ResultCode;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

/**
 * 异常类枚举
 *
 * @author CloudSen
 */
public enum ExceptionEnum {
    /**
     * 参数无效异常
     */
    PARAMETER_INVALID(ParameterInvalidException.class, HttpStatus.BAD_REQUEST, ResultCode.PARAMETER_IS_INVALID),
    DATA_NOT_FOUND(DataNotFoundException.class, HttpStatus.NOT_FOUND, ResultCode.DATA_NOT_FOUNT);

    private Class<? extends BusinessException> exceptionClass;
    private HttpStatus httpStatus;
    private ResultCode resultCode;

    ExceptionEnum(Class<? extends BusinessException> exceptionClass, HttpStatus httpStatus, ResultCode resultCode) {
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
    }

    /**
     * 通过异常类class获取详细信息
     *
     * @param eClass 异常类class
     * @return ExceptionEnum
     */
    public static ExceptionEnum parseExceptionClass(Class<? extends BusinessException> eClass) {
        return Arrays.stream(values())
                .filter(exceptionEnum -> exceptionEnum.getExceptionClass().equals(eClass))
                .findFirst()
                .orElseThrow(() -> new EnumCodeInvalidException("找不到异常{}对应的枚举信息", eClass.getSimpleName()));
    }

    public static void main(String[] args) {
        ExceptionEnum exceptionEnum = ExceptionEnum.parseExceptionClass(ParameterInvalidException.class);
        System.out.println(exceptionEnum.getHttpStatus());
        System.out.println(exceptionEnum.getResultCode());
    }

    public Class<? extends BusinessException> getExceptionClass() {
        return exceptionClass;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
