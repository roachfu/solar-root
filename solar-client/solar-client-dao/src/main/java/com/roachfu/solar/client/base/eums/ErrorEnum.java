package com.roachfu.solar.client.base.eums;

/**
 * 错误类型集合
 * @author fuqiang
 * @time 2017/3/4 12:28
 */
public enum ErrorEnum {

    /**
     * 200, 成功
     */
    SUCCEED(200, "成功"),

    /**
     * 404, 找不到资源
     */
    NOT_FOUNT(404, "资源不存在"),

    /** 420, 失败 */
    FAILURE(420, "失败"),

    /**
     * 500, 服务器繁忙, 请稍后再试
     */
    ERROR(500, "服务器繁忙, 请稍后再试");

    /** 错误码 */
    private Integer code;

    /** 错误信息 */
    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
