/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.common;


import com.sj.app.exception.ApplicationExceptionEnum;
import lombok.Getter;

/**
 * 基础错误枚举类
 *
 * @author ShiJu
 * @version 1.0
 */
@Getter
public enum BaseErrorCode implements ApplicationExceptionEnum {

    SUCCESS(200, "success"),
    SYSTEM_ERROR(90000, "服务器内部错误,请联系管理员"),
    PARAMETER_ERROR(90001, "参数校验错误"),

    ;

    private final int code;
    private final String msg;

    BaseErrorCode(int code, String error) {
        this.code = code;
        this.msg = error;
    }
}
