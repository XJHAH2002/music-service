package com.music.entity;

public class Author {
    private Integer id;
    private String name;
    private String avatar;
    private String intro;

    // getter/setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public String getIntro() { return intro; }
    public void setIntro(String intro) { this.intro = intro; }
}