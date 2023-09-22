/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.model.proto;

import lombok.Data;

import java.util.List;

/**
 * 获取用户信息
 *
 * @author ShiJu
 * @version 1.0
 */
@Data
public class GetUserInfoProto {

    private List<String> userIds;

    private List<String> standardField;

    private List<String> customField;
}
