package com.esc.mall.service;

import com.esc.mall.domain.CommonResult;
import com.esc.mall.domain.User;
import com.esc.mall.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户 接口层
 *
 * @author jiaorun
 * @date 2022/1/10 11:14
 **/
@FeignClient(value = "user-service", fallback = UserFallbackService.class)
@Component
public interface UserService {

    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    @PostMapping("/user/update")
    CommonResult update(@RequestBody User user);

    @GetMapping("/user/{id}")
    CommonResult getById(@PathVariable Long id);

    @GetMapping("/user/getByUsername")
    CommonResult<User> getUserByUsername(@RequestParam String username);

    @PostMapping("/user/delete/{id}")
    CommonResult delete(@PathVariable Long id);
}
