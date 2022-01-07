package com.esc.mall.service;

import com.esc.mall.domain.User;

import java.util.List;

/**
 * 用户 接口层
 *
 * @author jiaorun
 * @date 2022/1/6 15:29
 **/
public interface UserService {

    /**
     * 创建用户
     *
     * @author jiaorun
     * @data 2022/1/6 15:42
     * @param user
     * @return void
     */
    void create(User user);

    /**
     * 修改用户
     *
     * @author jiaorun
     * @data 2022/1/6 15:47
     * @param user
     * @return void
     */
    void update(User user);

    /**
     * 获取用户信息
     *
     * @author jiaorun
     * @data 2022/1/6 15:56
     * @param id
     * @return com.esc.mall.domain.User
     */
    User getUser(Long id);

    /**
     * 删除
     *
     * @author jiaorun
     * @data 2022/1/6 15:47
     * @param id
     * @return void
     */
    void delete(Long id);

    /**
     * 根据用户名查询
     *
     * @author jiaorun
     * @data 2022/1/6 15:48
     * @param username
     * @return com.esc.mall.domain.User
     */
    User getByUsername(String username);

    /**
     * 根据ID批量查询
     *
     * @author jiaorun
     * @data 2022/1/6 15:48
     * @param ids
     * @return java.util.List<com.esc.mall.domain.User>
     */
    List<User> getUserByIds(List<Long> ids);
}
