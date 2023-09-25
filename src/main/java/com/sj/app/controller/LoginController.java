/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.controller;

import com.sj.app.common.ResponseVO;
import com.sj.app.entry.AppUser;
import com.sj.app.model.dto.ImUserDataDto;
import com.sj.app.model.req.LoginReq;
import com.sj.app.model.req.RegisterReq;
import com.sj.app.model.req.SearchUserReq;
import com.sj.app.model.resp.LoginResp;
import com.sj.app.service.AppUserService;
import com.sj.app.service.LoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登录注册接口
 *
 * @author ShiJu
 * @version 1.0
 */
@RestController
@RequestMapping("v1")
public class LoginController {
    @Resource
    private LoginService loginService;
    @Resource
    private AppUserService appUserService;

    @PostMapping("/login")
    public ResponseVO<LoginResp> login(@RequestBody @Validated LoginReq req) {
        return loginService.login(req);
    }

    @PostMapping("/register")
    public ResponseVO<AppUser> register(@RequestBody @Validated RegisterReq req) {
        AppUser appUser = loginService.register(req);
        return ResponseVO.successResponse(appUser);
    }

    @PostMapping("/search")
    public ResponseVO<ImUserDataDto> searchUser(@RequestBody @Validated SearchUserReq req) {
        return appUserService.searchUser(req);
    }
}
