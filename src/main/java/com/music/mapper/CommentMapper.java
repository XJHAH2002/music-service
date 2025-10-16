package com.music.mapper;

import com.music.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CommentMapper {
    // 新增评论
    int addComment(Comment comment);
    // 根据音乐ID获取评论（含回复）
    List<Comment> findByMusicId(Integer musicId);
    // 点赞评论
    int likeComment(Integer id);
    // 删除评论（只能删除自己的或管理员）
    int deleteComment(Integer id, Integer userId, String role);
    // 管理员置顶评论
    int topComment(Integer id, Integer isTop);
}