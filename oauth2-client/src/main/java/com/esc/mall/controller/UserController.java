package com.esc.mall.controller;

import javafx.beans.binding.ObjectExpression;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 控制层
 *
 * @author jiaorun
 * @date 2022/1/25 10:01
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/auth/admin")
    @PreAuthorize("hasAuthority('admin')")
    public Object adminAuth() {
        return "Has admin auth!";
    }
}
