package com.collapseunion.commonutils.customexceptions;

/**
 * 参数无效异常
 *
 * @author CloudSen
 */
public class ParameterInvalidException extends BusinessException {

    public ParameterInvalidException() {
        super();
    }

    public ParameterInvalidException(String message) {
        super(message);
    }

    public ParameterInvalidException(String message, Object data) {
        super(message, data);
    }

    public ParameterInvalidException(String originStr, Object... objects) {
        super(originStr, objects);
    }

    public ParameterInvalidException(String originStr, Object data, Object... objects) {
        super(originStr, data, objects);
    }
}
