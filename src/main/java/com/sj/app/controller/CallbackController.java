/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.controller;

import com.sj.app.common.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回调接口
 *
 * @author ShiJu
 * @version 1.0
 */
@Slf4j
@RequestMapping("v1")
@RestController
public class CallbackController {

    @PostMapping("/callback")
    public ResponseVO<String> callback(@RequestBody String data, String command, Integer appId) {
        log.info("应用{}收到[{}]回调数据：{}", appId, command, data);
        return ResponseVO.successResponse();
    }
}
