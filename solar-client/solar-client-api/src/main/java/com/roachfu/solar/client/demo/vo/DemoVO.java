package com.roachfu.solar.client.demo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.roachfu.solar.client.base.vo.BaseVO;

/**
 * @author roach
 * @date 13/08/2017 11:30
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DemoVO extends BaseVO {

    private static final long serialVersionUID = -3480648210312592901L;

    private Long id;

    private String demoName;

    private String demoValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
