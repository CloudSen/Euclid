package com.collapseunion.config.exception.customexception;

import com.collapseunion.config.exception.ExceptionEnum;
import lombok.ToString;
import org.thymeleaf.util.StringUtils;

/**
 * 业务异常类
 *
 * @author CloudSen
 */
@ToString
public class BusinessException extends RuntimeException {

    private String code;
    private String message;
    private Object data;

    BusinessException() {
        ExceptionEnum exceptionEnum = ExceptionEnum.parseExceptionClass(this.getClass());
        this.code = exceptionEnum.getResultCode().getCode();
        this.message = exceptionEnum.getResultCode().getMessage();
    }

    BusinessException(String message) {
        this();
        this.message = message;
    }

    BusinessException(String message, Object data) {
        this(message);
        this.data = data;
    }

    BusinessException(String originStr, Object... objects) {
        this();
        String template = StringUtils.replace(originStr, "{}", "%s");
        this.message = String.format(template, objects);
    }

    BusinessException(String originStr, Object data, Object... objects) {
        this(originStr, objects);
        this.data = data;
    }
}
