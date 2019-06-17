package com.collapseunion.config.exception.customexception;

/**
 * 数据未找到异常
 *
 * @author CloudSen
 */
public class DataNotFoundException extends BusinessException {

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Object data) {
        super(message, data);
    }

    public DataNotFoundException(String originStr, Object... objects) {
        super(originStr, objects);
    }

    public DataNotFoundException(String originStr, Object data, Object... objects) {
        super(originStr, data, objects);
    }
}
