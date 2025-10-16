package com.music.service.impl;

import com.music.entity.User;
import com.music.mapper.UserMapper;
import com.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(User user) {
        // 注册逻辑（原逻辑保持不变）
        return userMapper.addUser(user) > 0;
    }

    @Override
    public User login(String username, String password) {
        // 登录逻辑（原逻辑保持不变）
        return userMapper.findByUsername(username);
    }

    @Override
    public User findById(Integer id) {
        // 新增：根据ID查用户
        return userMapper.findById(id);
    }

    @Override
    public boolean updateUserInfo(User user) {
        // 新增：修改用户资料
        return userMapper.updateUserInfo(user) > 0;
    }

    @Override
    public boolean updatePassword(Integer userId, String newPassword) {
        // 新增：修改密码
        return userMapper.updatePassword(userId, newPassword) > 0;
    }
}