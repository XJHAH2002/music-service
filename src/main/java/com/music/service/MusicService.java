package com.music.service;

import com.music.entity.Music;
import com.music.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicMapper musicMapper;

    // 获取所有音乐
    public List<Music> getAllMusic() {
        return musicMapper.findAll();
    }

    // 搜索音乐
    public List<Music> searchMusic(String keyword) {
        return musicMapper.search(keyword);
    }
}
