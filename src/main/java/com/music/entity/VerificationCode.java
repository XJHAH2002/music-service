package com.music.entity;

import java.util.Date;

public class VerificationCode {
    private Integer id;
    private String email;
    private String code;
    private Date expireTime;
    private String type;

    // getter/setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Date getExpireTime() { return expireTime; }
    public void setExpireTime(Date expireTime) { this.expireTime = expireTime; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}