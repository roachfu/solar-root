package com.roachfu.solar.client.demo.dto;

import com.roachfu.solar.client.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 添加demo请求参数
 *
 * @author roach
 * @date 17/08/2017 22:56
 */
public class DemoAddDTO extends BaseDTO {

    private static final long serialVersionUID = -1466766984494701035L;

    @NotBlank(message = "demo name can't be null")
    private String demoName;

    @NotBlank(message = "demo value can't be null")
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
