package com.music.entity;

import java.util.Date;

public class PlayHistory {
    private Integer id; // 新增：主键ID
    private Integer userId; // 新增：用户ID
    private Integer musicId; // 新增：音乐ID
    private Date playTime; // 新增：播放时间

    // 扩展：音乐信息
    private Music music;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getMusicId() { return musicId; }
    public void setMusicId(Integer musicId) { this.musicId = musicId; }
    public Date getPlayTime() { return playTime; }
    public void setPlayTime(Date playTime) { this.playTime = playTime; }
    public Music getMusic() { return music; }
    public void setMusic(Music music) { this.music = music; }

}