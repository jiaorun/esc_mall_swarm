package com.esc.mall.controller;

import com.esc.mall.domain.CommonResult;
import com.esc.mall.domain.User;
import com.esc.mall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 用户 控制层
 *
 * @author jiaorun
 * @date 2022/1/6 16:08
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        userService.create(user);
        return new CommonResult(200, "操作成功");
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        userService.update(user);
        return new CommonResult(200, "操作成功");
    }

    @GetMapping("/{id}")
    public CommonResult<User> getById(@PathVariable Long id) {
        User user = userService.getUser(id);
        LOGGER.info("根据id获取用户信息,用户名称为:{}", user.getUsername());
        return new CommonResult<>(user, 200, "操作成功");
    }

    @GetMapping("/getUserByIds")
    public CommonResult<List<User>> getUserByIds(@RequestParam List<Long> ids) {
        List<User> userList = userService.getUserByIds(ids);
        LOGGER.info("根据ids获取用户信息,用户列表为:{}", userList);
        return new CommonResult<List<User>>(userList, 200, "操作成功");
    }

    @GetMapping("/getByUsername")
    public CommonResult<User> getUserByUsername(@RequestParam String username) {
        User user = userService.getByUsername(username);
        return new CommonResult<User>(user, 200, "操作成功");
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        userService.delete(id);
        return new CommonResult(200, "操作成功");
    }
}
