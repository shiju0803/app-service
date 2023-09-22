/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.service.impl;

import cn.hutool.json.JSONUtil;
import com.sj.app.common.ResponseVO;
import com.sj.app.config.AppConfig;
import com.sj.app.entry.AppUser;
import com.sj.app.model.dto.ImUserDataDto;
import com.sj.app.model.proto.GetUserInfoProto;
import com.sj.app.model.proto.ImportUserProto;
import com.sj.app.model.resp.ImportUserResp;
import com.sj.app.service.ImService;
import com.sj.app.util.HttpRequestUtil;
import com.sj.app.util.SigAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ShiJu
 * @version 1.0
 */
@Slf4j
@Service
public class ImServiceImpl implements ImService {
    private static final Object lock = new Object();
    private volatile static Map<String, Object> parameter = null;
    @Resource
    private HttpRequestUtil httpRequestUtil;
    @Resource
    private AppConfig appConfig;

    /**
     * 导入IM用户的方法
     *
     * @param users 用户信息
     */
    @Override
    public ResponseVO<ImportUserResp> importUser(List<AppUser> users) {
        ImportUserProto proto = new ImportUserProto();
        List<ImportUserProto.UserData> userData = new ArrayList<>();
        for (AppUser user : users) {
            ImportUserProto.UserData data = new ImportUserProto.UserData();
            data.setUserId(user.getUserId());
            data.setPassword(user.getPassword());
            data.setUserType(1);
            userData.add(data);
        }

        String uri = "/user/importUser";
        try {
            proto.setUserData(userData);
            return httpRequestUtil.doPost(getUrl(uri), ResponseVO.class, getParameter(), JSONUtil.toJsonStr(proto),
                                          "");
        } catch (Exception e) {
            log.error("请求IM服务失败:", e);
        }
        return ResponseVO.errorResponse();
    }

    /**
     * 获取用户信息
     *
     * @param users 用户id集合
     */
    @Override
    public ResponseVO<ImUserDataDto> getUserInfo(List<String> users) {
        GetUserInfoProto proto = new GetUserInfoProto();
        proto.setUserIds(users);

        String uri = "/user/data/getUserInfo";
        try {
            return httpRequestUtil.doPost(getUrl(uri), ResponseVO.class, getParameter(), null,
                                          JSONUtil.toJsonStr(proto), "");
        } catch (Exception e) {
            log.error("请求IM服务失败:", e);
        }
        return ResponseVO.errorResponse();
    }

    private String getUrl(String uri) {
        return appConfig.getImUrl() + "/" + appConfig.getImVersion() + uri;
    }

    private Map<String, Object> getParameter() {
        if (parameter == null) {
            synchronized (lock) {
                if (parameter == null) {
                    SigAPI sigAPI = new SigAPI(appConfig.getAppId(), appConfig.getSecretKey());
                    Map<String, Object> temp = new ConcurrentHashMap<>();
                    temp.put("appId", appConfig.getAppId());
                    temp.put("userSign", sigAPI.genUserSign(appConfig.getAdminId(), 500000L));
                    temp.put("identifier", appConfig.getAdminId());
                    parameter = temp;
                }
            }
        }
        return parameter;
    }
}
