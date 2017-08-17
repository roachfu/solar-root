package com.roachfu.solar.client.demo.entity;

import com.roachfu.solar.client.base.entity.BaseEntity;

/**
 * Demo实体
 * <p>
 * Created by roach on 13/08/2017.
 */
public class Demo extends BaseEntity {

    private static final long serialVersionUID = 2685274710355409881L;

    /**
     * demo 名称
     */
    private String demoName;

    /**
     * demo 值
     */
    private String demoValue;

    /**
     * 删除标志：1=已删除；0=未删除
     */
    private Integer delFlag;

    @Override
    public void init(){
        super.init();
        this.demoName = "";
        this.demoValue = "";
        this.delFlag = 0;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public String getDemoValue() {
        return demoValue;
    }

    public void setDemoValue(String demoValue) {
        this.demoValue = demoValue;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

}
