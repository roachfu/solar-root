package com.roachfu.solar.client.base.dto;

import java.io.Serializable;

/**
 * 数据传输实体基础类
 *
 * @author roach
 * @date 17/08/2017 22:59
 */
public class BaseDTO implements Serializable{
    private static final long serialVersionUID = -8045539113237003717L;

    @Override
    public String toString() {
        return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this);
    }
}
