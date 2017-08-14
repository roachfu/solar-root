package com.roachfu.solar.client.base.vo;

import java.io.Serializable;

/**
 * 基础返回对象
 *
 * @author roach
 * @date 13/08/2017 11:31
 */
public class BaseVO implements Serializable{

    private static final long serialVersionUID = -4272346594007483510L;

    @Override
    public String toString() {
        return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this);
    }
}
