/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.enums;


import com.sj.app.exception.ApplicationExceptionEnum;
import lombok.Getter;

/**
 * 应用错误码枚举类
 *
 * @author ShiJu
 * @version 1.0
 */
@Getter
public enum ErrorCode implements ApplicationExceptionEnum {
    USER_NOT_EXIST(10000, "用户不存在"),

    USERNAME_OR_PASSWORD_ERROR(10001, "用户名或密码错误"),

    MOBILE_IS_REGISTER(10002, "该手机号已注册了用户"),

    USERNAME_IS_REGISTER(10003, "该用户名已注册了用户"),

    REGISTER_ERROR(10004, "注册失败"),

    REPORT_TAG_IS_NOT_EXIST(10005, "举报标签不存在"),

    REDPACKET_IS_NOT_EXIST(10006, "红包不存在"),

    USER_REDPACKET_IS_OPEN(10007, "用户已抢过该红包"),

    REDPACKET_IS_EXPIRE(10008, "红包已过期"),

    REDPACKET_IS_FINISH(10009, "红包已抢完"),

    REDPACKET_IS_HOT(10010, "红包火爆请稍后再试"),

    TRY_LOCR_PACKET_INTERRUPTED(10011, "抢红包时被中断了"),

    ;

    private final int code;
    private final String msg;

    ErrorCode(int code, String error) {
        this.code = code;
        this.msg = error;
    }
}
