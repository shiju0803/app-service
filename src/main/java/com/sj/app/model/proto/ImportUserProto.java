/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.model.proto;

import lombok.Data;

import java.util.List;

/**
 * 导入用户信息
 *
 * @author ShiJu
 * @version 1.0
 */
@Data
public class ImportUserProto {

    private Integer appId;

    private List<UserData> userData;

    @Data
    public static class UserData {
        // 用户id
        private String userId;

        // 用户名称
        private String nickName;

        private String password;

        // 头像
        private String photo;

        // 性别
        private Integer userSex;

        // 个性签名
        private String selfSignature;

        // 加好友验证类型（Friend_AllowType） 1需要验证
        private Integer friendAllowType;

        // 管理员禁止用户添加加好友：0 未禁用 1 已禁用
        private Integer disableAddFriend;

        // 禁用标识(0 未禁用 1 已禁用)
        private Integer forbiddenFlag;

        // 禁言标识
        private Integer silentFlag;
        /**
         * 用户类型 1-普通用户 2-客服 3-机器人
         */
        private Integer userType;
    }
}
