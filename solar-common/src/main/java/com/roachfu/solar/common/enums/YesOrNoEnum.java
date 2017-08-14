package com.roachfu.solar.common.enums;

/**
 * yes or no 的枚举
 *
 * @author roach
 * @date 13/08/2017 11:11
 */
public enum YesOrNoEnum {

    /**
     * 表示true、是、对等
     */
    YES(1),

    /**
     * 表示false、不是、错等
     */
    NO(0);

    private Integer code;

    YesOrNoEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
