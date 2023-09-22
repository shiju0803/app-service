package com.sj.app.enums;

import lombok.Getter;

/**
 * 登录类型枚举类
 *
 * @author ShiJu
 * @version 1.0
 */
@Getter
public enum LoginTypeEnum {

    /**
     * 1 username；2 验证码 3手机号+验证码
     */
    USERNAME_PASSWORD(1, "用户名密码登录"),

    SMS_CODE(2, "短信验证码登录"),

    SMS_PASSWORD(3, "手机号+验证码登录");

    private final int code;
    private final String desc;

    LoginTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
