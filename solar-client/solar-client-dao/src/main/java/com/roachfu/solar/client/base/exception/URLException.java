package com.roachfu.solar.client.base.exception;

import com.roachfu.solar.client.base.eums.ErrorEnum;

/**
 * url错误异常
 *
 * @author roach
 * @date 17/08/2017 22:46
 */
public class URLException extends ApplicationException {

    private static final long serialVersionUID = 162138262958386131L;

    public URLException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
