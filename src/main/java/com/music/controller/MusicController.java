package com.music.controller;

import com.music.entity.Music;
import com.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MusicController {

    @Autowired
    private MusicService musicService;

    // 获取所有音乐：GET请求 /music/all
    @GetMapping("/music/all")
    public List<Music> getAllMusic() {
        return musicService.getAllMusic();
    }

    // 搜索音乐：GET请求 /music/search?keyword=关键词
    @GetMapping("/music/search")
    public List<Music> searchMusic(@RequestParam String keyword) {
        return musicService.searchMusic(keyword);
    }
}