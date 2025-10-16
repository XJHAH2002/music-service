package com.music.controller;

import com.music.entity.Collect;
import com.music.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CollectController {

    @Autowired
    private CollectService collectService;

    // 添加收藏：POST请求 /collect/add
    @PostMapping("/collect/add")
    public String addCollect(@RequestBody Collect collect) { // 用@RequestBody接收JSON
        boolean success = collectService.addCollect(collect.getUserId(), collect.getMusicId());
        return success ? "收藏成功" : "收藏失败";
    }



    // 取消收藏：POST请求 /collect/delete
    @PostMapping("/collect/delete")
    public String deleteCollect(@RequestBody Collect collect) { // 用@RequestBody接收JSON
        boolean success = collectService.deleteCollect(collect.getUserId(), collect.getMusicId());
        return success ? "取消收藏成功" : "取消收藏失败";
    }

    // 获取用户收藏：GET请求 /collect/user?userId=1
    @GetMapping("/collect/user")
    public List<Collect> getUserCollects(@RequestParam Integer userId) {
        return collectService.getUserCollects(userId);
    }
}