package com.music.service;

import com.music.entity.Comment;
import com.music.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    // 新增评论
    public boolean addComment(Comment comment) {
        return commentMapper.addComment(comment) > 0;
    }

    // 获取音乐的评论（含回复）
    public List<Comment> getMusicComments(Integer musicId) {
        return commentMapper.findByMusicId(musicId);
    }

    // 点赞评论
    public boolean likeComment(Integer id) {
        return commentMapper.likeComment(id) > 0;
    }

    // 删除评论（验证权限）
    public boolean deleteComment(Integer id, Integer userId, String role) {
        // 管理员或评论者本人可删除
        return commentMapper.deleteComment(id, userId, role) > 0;
    }

    // 管理员置顶评论
    public boolean topComment(Integer id, Integer isTop, String role) {
        if (!"admin".equals(role)) {
            return false; // 非管理员无权操作
        }
        return commentMapper.topComment(id, isTop) > 0;
    }
}