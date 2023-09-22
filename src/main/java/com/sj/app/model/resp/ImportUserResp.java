/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.model.resp;

import lombok.Data;

import java.util.Set;

/**
 * 导入用户信息请求响应
 *
 * @author ShiJu
 * @version 1.0
 */
@Data
public class ImportUserResp {
    private Set<String> successId;

    private Set<String> errorId;
}
