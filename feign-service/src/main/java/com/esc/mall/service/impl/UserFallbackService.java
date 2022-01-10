package com.esc.mall.service.impl;

import com.esc.mall.domain.CommonResult;
import com.esc.mall.domain.User;
import com.esc.mall.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务降级实现类
 *
 * @author jiaorun
 * @date 2022/1/10 12:00
 **/
@Component
public class UserFallbackService implements UserService {


    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult(500, "调用失败，服务被降级");
    }

    @Override
    public CommonResult getById(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult(defaultUser);
    }

    @Override
    public CommonResult<User> getUserByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult(defaultUser);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult(500, "调用失败，服务被降级");
    }
}
