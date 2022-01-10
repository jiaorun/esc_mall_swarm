package com.esc.mall.controller;

import com.esc.mall.domain.CommonResult;
import com.esc.mall.domain.User;
import com.esc.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户 控制层
 *
 * @author jiaorun
 * @date 2022/1/10 11:28
 **/
@RestController
@RequestMapping("/user")
public class UserFeignController {

    private UserService userService;

    @Autowired
    public UserFeignController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
