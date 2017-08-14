package com.roachfu.solar.client.base.entity;

import java.io.Serializable;

/**
 * API返回实体
 *
 * @author roach
 * @date 13/08/2017 10:59
 */
public class APIResponse implements Serializable {

    private static final long serialVersionUID = 3413659173456891928L;

    /** 错误信息元数据 */
    private Meta meta;

    /** 返回结果 */
    private Object data;

    public APIResponse() {
        this.meta = new Meta(200, "ok");
    }

    public APIResponse(Object data){
        this.meta = new Meta(200, "ok");
        if(data != null){
            this.data = data;
        }
    }

    public APIResponse(Meta meta, Object data) {
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this);
    }

}
