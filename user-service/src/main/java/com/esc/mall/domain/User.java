package com.esc.mall.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户 实体类
 *
 * @author jiaorun
 * @date 2022/1/6 15:34
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -9039005076942512931L;

    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public User() {}

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
