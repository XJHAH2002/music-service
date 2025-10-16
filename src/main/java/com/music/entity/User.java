package com.music.entity;

import java.util.Date;

public class User {
    private Integer id; // 新增：用户ID
    private String username; // 新增：用户名
    private String password; // 新增：密码
    private String email;    // 新增：邮箱
    private Date createTime;     // 新增：创建时间
    private String avatar; // 新增：头像
    private Integer age;   // 新增：年龄
    private String role;   // 新增：角色（user/admin）

    // getter/setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}