package com.roachfu.solar.client.base.exception;

import com.roachfu.solar.client.base.eums.ErrorEnum;

/**
 * 应用全局异常
 *
 * @author roach
 * @date 17/08/2017 22:34
 */
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 710449721773898205L;

    /**
     * 错误代码
     */
    private final Integer code;

    /**
     * 错误信息
     */
    private final String error;

    public ApplicationException(Integer code, String error) {
        super(error);
        this.code = code;
        this.error = error;
    }

    public ApplicationException(ErrorEnum errorEnum){
        super(errorEnum.getMsg());
        this.code = errorEnum.getCode();
        this.error = errorEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getError() {
        return error;
    }
}
