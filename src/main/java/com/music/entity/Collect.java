package com.music.entity;

import java.util.Date;

public class Collect {
    private Integer id;
    private Integer userId;
    private Integer musicId;
    private Date createTime;
    private Integer categoryId; // 新增：收藏分类ID

    // 扩展：前端显示音乐信息
    private Music music;

    public Music getMusic() { return music; }
    public void setMusic(Music music) { this.music = music; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getMusicId() { return musicId; }
    public void setMusicId(Integer musicId) { this.musicId = musicId; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
}
