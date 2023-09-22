/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.model.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 登录请求实体
 *
 * @author ShiJu
 * @version 1.0
 */
@Data
public class LoginReq {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotNull(message = "请选择登录方式")
    //登录方式 1 用户名+密码 2手机号+验证码
    private Integer loginType;
}
