package com.music.controller;

import com.music.entity.User;
import com.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 密码加密工具方法（MD5）
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xff);
                if (hex.length() == 1) sb.append("0");
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return password; // 异常时返回原密码（仅测试用）
        }
    }

    // 注册、登录、修改资料等接口...
    // （以下是你已有的接口代码，保持不变）
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        boolean success = userService.register(user);
        return success ? "注册成功！" : "注册失败，用户名已存在";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User result = userService.login(user.getUsername(), user.getPassword());
        return result != null
                ? "登录成功！用户ID：" + result.getId()
                : "用户名或密码错误";
    }

    @PostMapping("/update/info")
    public String updateUserInfo(@RequestBody User user) {
        User loginUser = userService.findById(user.getId());
        if (loginUser == null) {
            return "用户不存在";
        }
        boolean success = userService.updateUserInfo(user);
        return success ? "资料修改成功" : "修改失败";
    }

    @PostMapping("/update/password")
    public String updatePassword(
            @RequestParam Integer userId,
            @RequestParam String oldPassword,
            @RequestParam String newPassword
    ) {
        User user = userService.findById(userId);
        if (!user.getPassword().equals(encryptPassword(oldPassword))) {
            return "旧密码错误";
        }
        boolean success = userService.updatePassword(userId, encryptPassword(newPassword));
        return success ? "密码修改成功" : "修改失败";
    }
}