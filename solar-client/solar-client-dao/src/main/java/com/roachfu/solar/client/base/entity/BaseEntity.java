package com.roachfu.solar.client.base.entity;

import com.roachfu.solar.common.util.id.IdWorker;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体
 *
 * @author roach
 * @date 13/08/2017 10:38
 */
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = -7703504197898304805L;
    
    /**
     * id
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新用户
     */
    private String updateUser;

    public void init(){
        IdWorker idWorker = IdWorker.getFlowIdWorkerInstance();
        this.id = Long.toString(idWorker.nextId());
        this.createTime = new Date();
        this.createUser = "";
        this.updateTime = new Date();
        this.updateUser = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this);
    }
}
