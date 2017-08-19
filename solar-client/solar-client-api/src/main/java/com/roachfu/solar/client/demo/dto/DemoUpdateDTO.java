package com.roachfu.solar.client.demo.dto;

import com.roachfu.solar.client.base.dto.BaseDTO;

/**
 * demo更新请求参数实体
 *
 * @author roach
 * @date 19/08/2017 18:41
 */
public class DemoUpdateDTO extends BaseDTO {

    private static final long serialVersionUID = 3209604711760607954L;

    private String id;

    private String demoName;

    private String demoValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
