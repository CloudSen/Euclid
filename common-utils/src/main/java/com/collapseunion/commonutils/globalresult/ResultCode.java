package com.collapseunion.commonutils.globalresult;

import com.collapseunion.commonutils.customexceptions.EnumCodeInvalidException;

import java.util.Arrays;

/**
 * 异常代码-消息 枚举
 *
 * @author CloudSen
 */
public enum ResultCode {
    /**
     * 0001 参数无效
     */
    PARAMETER_IS_INVALID("0001", "参数无效"),
    FAILED_TO_HANDLE("0002", "处理失败"),
    DATA_NOT_FOUNT("0003", "数据不存在");

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code获得枚举对象
     *
     * @param code 结果码
     * @return ResultCodeEnum枚举对象
     */
    public static ResultCode getResultCodeByCode(String code) {
        return Arrays.stream(values())
                .filter(rc -> rc.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new EnumCodeInvalidException("异常代码Code:{}对应的枚举对象不存在", code));
    }

    /**
     * 通过code获得消息
     *
     * @param code 结果码
     * @return 消息
     */
    public static String getMessageByCode(String code) {
        return Arrays.stream(values())
                .filter(rc -> rc.getCode().equalsIgnoreCase(code))
                .map(ResultCode::getMessage)
                .findFirst()
                .orElseThrow(() -> new EnumCodeInvalidException("异常代码Code:{}对应的枚举消息不存在", code));
    }

    public static void main(String[] args) {
        System.out.println(getResultCodeByCode("0001").getCode());
        System.out.println(getResultCodeByCode("0001").getMessage());
        System.out.println(getMessageByCode("0001"));
        System.out.println(getMessageByCode("null"));
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
