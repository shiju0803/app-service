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
