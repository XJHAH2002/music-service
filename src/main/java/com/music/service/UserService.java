package com.music.service;

import com.music.entity.User;

public interface UserService {
    boolean register(User user);
    User login(String username, String password);
    // 新增：根据ID查询用户
    User findById(Integer id);
    // 新增：修改用户资料
    boolean updateUserInfo(User user);
    // 新增：修改密码
    boolean updatePassword(Integer userId, String newPassword);
}