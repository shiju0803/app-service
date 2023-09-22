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
