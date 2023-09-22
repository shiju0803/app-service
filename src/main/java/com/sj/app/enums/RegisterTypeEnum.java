package com.sj.app.enums;

import lombok.Getter;

/**
 * 注册类型枚举类
 *
 * @author ShiJu
 * @version 1.0
 */
@Getter
public enum RegisterTypeEnum {

    /**
     * 1 username；2 MOBILE。
     */
    USERNAME(1, "用户名注册"),

    MOBILE(2, "手机号注册"),

    ;

    private final int code;
    private final String desc;

    RegisterTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
