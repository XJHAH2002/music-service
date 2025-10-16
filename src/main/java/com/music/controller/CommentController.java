package com.music.controller;

import com.music.entity.Comment;
import com.music.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 新增评论
    @PostMapping("/comment/add")
    public String addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment) ? "评论成功" : "评论失败";
    }

    // 获取音乐的评论
    @GetMapping("/comment/music/{musicId}")
    public List<Comment> getMusicComments(@PathVariable Integer musicId) {
        return commentService.getMusicComments(musicId);
    }

    // 点赞评论
    @PostMapping("/comment/like/{id}")
    public String likeComment(@PathVariable Integer id) {
        return commentService.likeComment(id) ? "点赞成功" : "点赞失败";
    }

    // 删除评论
    @PostMapping("/comment/delete")
    public String deleteComment(
            @RequestParam Integer id,
            @RequestParam Integer userId,
            @RequestParam String role
    ) {
        return commentService.deleteComment(id, userId, role) ? "删除成功" : "无权限删除";
    }

    // 管理员置顶评论
    @PostMapping("/comment/top")
    public String topComment(
            @RequestParam Integer id,
            @RequestParam Integer isTop,
            @RequestParam String role
    ) {
        return commentService.topComment(id, isTop, role) ? "操作成功" : "无权限操作";
    }
}