/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 应用配置类
 *
 * @author ShiJu
 * @version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "appconfig")
public class AppConfig {

    private String imUrl;

    private String imVersion;

    private Integer appId;

    private String adminId;

    private String secretKey;

    private String jwtKey;

    private Integer jwtExpireTime;
}
