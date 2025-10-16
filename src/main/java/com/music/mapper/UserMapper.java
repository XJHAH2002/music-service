package com.music.mapper;

import com.music.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
    int addUser(User user);
    // 新增：根据ID查用户
    User findById(Integer id);
    // 新增：修改用户资料
    int updateUserInfo(User user);
    // 新增：修改密码
    int updatePassword(Integer userId, String newPassword);
}