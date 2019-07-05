package com.collapseunion.customexceptions;

/**
 * 重复添加数据异常
 *
 * @author CloudSen
 */
public class DuplicateDataException extends BusinessException {

    public DuplicateDataException() {
        super();
    }

    public DuplicateDataException(String message) {
        super(message);
    }

    public DuplicateDataException(String message, Object data) {
        super(message, data);
    }

    public DuplicateDataException(String originStr, Object... objects) {
        super(originStr, objects);
    }

    public DuplicateDataException(String originStr, Object data, Object... objects) {
        super(originStr, data, objects);
    }
}
