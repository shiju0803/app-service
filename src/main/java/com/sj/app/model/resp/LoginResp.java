/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.model.resp;

import lombok.Data;

/**
 * 用户登录请求响应
 *
 * @author ShiJu
 * @version 1.0
 */
@Data
public class LoginResp {

    //im的token
    private String imUserSign;

    //自己的token
    private String userSign;

    private String userId;

    private Integer appId;
}
