package com.collapseunion.commonutils.customexceptions;

/**
 * 解析枚举code失败异常
 *
 * @author CloudSen
 */
public class EnumCodeInvalidException extends BusinessException {

    public EnumCodeInvalidException() {
        super();
    }

    public EnumCodeInvalidException(String message) {
        super(message);
    }

    public EnumCodeInvalidException(String message, Object data) {
        super(message, data);
    }

    public EnumCodeInvalidException(String originStr, Object... objects) {
        super(originStr, objects);
    }

    public EnumCodeInvalidException(String originStr, Object data, Object... objects) {
        super(originStr, data, objects);
    }
}
