/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.model.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 搜索用户请求实体
 *
 * @author ShiJu
 * @version 1.0
 */
@Data
public class SearchUserReq {

    @NotBlank(message = "关键字不能为空")
    private String keyWord;

    @NotNull(message = "搜索方式不能为空")
    private Integer searchType;
}
