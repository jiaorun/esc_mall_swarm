package com.esc.mall.service.impl;

import com.esc.mall.domain.CommonResult;
import com.esc.mall.domain.User;
import com.esc.mall.service.UserService;
import org.springframework.stereotype.Component;

/**
 * 用户 逻辑实现层
 *
 * @author jiaorun
 * @date 2022/1/25 16:33
 **/
@Component
public class UserFallbackService implements UserService {

    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult(defaultUser, 200, "服务降级返回");
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult(defaultUser, 200, "服务降级返回");
    }

    @Override
    public CommonResult getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult(defaultUser, 200, "服务降级返回");
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult(500, "调用失败，服务被降级");
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult(500, "调用失败，服务被降级");
    }
}
