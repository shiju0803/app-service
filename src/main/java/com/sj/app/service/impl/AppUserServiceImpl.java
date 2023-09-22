/*
 * Copyright (c) ShiJu  2023 - 2023. 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 */

package com.sj.app.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sj.app.common.ResponseVO;
import com.sj.app.entry.AppUser;
import com.sj.app.enums.ErrorCode;
import com.sj.app.enums.RegisterTypeEnum;
import com.sj.app.exception.ApplicationException;
import com.sj.app.mapper.AppUserMapper;
import com.sj.app.model.dto.ImUserDataDto;
import com.sj.app.model.req.RegisterReq;
import com.sj.app.model.req.SearchUserReq;
import com.sj.app.model.resp.ImportUserResp;
import com.sj.app.service.AppUserService;
import com.sj.app.service.ImService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 用户相关接口实现类
 *
 * @author ShiJu
 * @version 1.0
 */
@Slf4j
@Service
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements AppUserService {
    @Resource
    private AppUserMapper appUserMapper;
    @Resource
    private ImService imService;

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param userName 用户名
     * @param password 密码
     */
    @Override
    public AppUser getUserByUserNameAndPassword(String userName, String password) {
        LambdaQueryWrapper<AppUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AppUser::getUserName, userName);
        wrapper.eq(AppUser::getPassword, password);
        return appUserMapper.selectOne(wrapper);
    }

    /**
     * 根据手机号查询用户信息
     *
     * @param mobile 手机号
     */
    @Override
    public AppUser getUserByMobile(String mobile) {
        LambdaQueryWrapper<AppUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AppUser::getMobile, mobile);
        return appUserMapper.selectOne(wrapper);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名称
     */
    @Override
    public AppUser getUserByUserName(String userName) {
        LambdaQueryWrapper<AppUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AppUser::getUserName, userName);
        return appUserMapper.selectOne(wrapper);
    }

    /**
     * 用户注册具体逻辑
     *
     * @param req 注册信息
     */
    @Override
    public AppUser registerUser(RegisterReq req) {
        AppUser user = new AppUser();
        user.setUserName(req.getUserName());
        user.setPassword(req.getPassword());
        user.setMobile(req.getMobile());
        if (ObjectUtil.equal(req.getRegisterType(), RegisterTypeEnum.MOBILE.getCode())) {
            user.setUserId(req.getMobile());
        }
        if (ObjectUtil.equal(req.getRegisterType(), RegisterTypeEnum.USERNAME.getCode())) {
            user.setUserId(req.getUserName());
        }
        appUserMapper.insert(user);

        List<AppUser> users = new ArrayList<>();
        users.add(user);
        ResponseVO<ImportUserResp> responseVO = imService.importUser(users);
        if (responseVO.isOk()) {
            ImportUserResp importUserResp = JSONUtil.parseObj(responseVO.getData()).toBean(ImportUserResp.class);
            Set<String> successId = importUserResp.getSuccessId();
            if (!successId.contains(user.getUserId())) {
                throw new ApplicationException(ErrorCode.REGISTER_ERROR);
            }
            return user;
        }
        throw new ApplicationException(responseVO.getCode(), responseVO.getMsg());
    }

    /**
     * 搜索用户
     *
     * @param req 搜索参数
     */
    @Override
    public ResponseVO<ImUserDataDto> searchUser(SearchUserReq req) {
        List<String> userIds = appUserMapper.searchUser(req);
        return imService.getUserInfo(userIds);
    }
}
