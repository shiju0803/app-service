package com.sj.app.model.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户注册请求实体
 *
 * @author ShiJu
 * @version 1.0
 */
@Data
public class RegisterReq {

    private String userName;

    private String mobile;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotNull(message = "请选择注册方式")
    //注册方式 1手机号注册 2 用户名
    private Integer registerType;

    private String proto;
}
