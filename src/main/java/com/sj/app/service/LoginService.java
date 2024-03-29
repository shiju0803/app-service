/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.service;

import com.sj.app.common.ResponseVO;
import com.sj.app.entry.AppUser;
import com.sj.app.model.req.LoginReq;
import com.sj.app.model.req.RegisterReq;
import com.sj.app.model.resp.LoginResp;

/**
 * 用户相关接口
 *
 * @author ShiJu
 * @version 1.0
 */
public interface LoginService {
    /**
     * IM用户登录方法
     *
     * @param req 登录参数
     * @return 路由信息
     */
    ResponseVO<LoginResp> login(LoginReq req);

    /**
     * 注册我们的服务并向im导入用户
     *
     * @param req 登录参数
     * @return 路由信息
     */
    AppUser register(RegisterReq req);
}
