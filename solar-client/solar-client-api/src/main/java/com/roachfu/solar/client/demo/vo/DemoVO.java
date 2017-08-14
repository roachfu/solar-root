package com.roachfu.solar.client.demo.vo;

import com.roachfu.solar.client.base.vo.BaseVO;

/**
 * @author roach
 * @date 13/08/2017 11:30
 */
public class DemoVO extends BaseVO{

    private static final long serialVersionUID = -3480648210312592901L;

    private String demoName;

    private String demoValue;

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
