package com.music.service;

import com.music.entity.Collect;
import com.music.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollectService {

    @Autowired
    private CollectMapper collectMapper;

    // 添加收藏
    public boolean addCollect(Integer userId, Integer musicId) {
        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setMusicId(musicId);
        int rows = collectMapper.addCollect(collect);
        return rows > 0;
    }

    // 取消收藏
    public boolean deleteCollect(Integer userId, Integer musicId) {
        int rows = collectMapper.deleteCollect(userId, musicId);
        return rows > 0;
    }

    // 获取用户的收藏列表
    public List<Collect> getUserCollects(Integer userId) {
        return collectMapper.findByUserId(userId);
    }
}