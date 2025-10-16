package com.music.mapper;

import com.music.entity.Collect;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CollectMapper {
    // 添加收藏
    int addCollect(Collect collect);

    // 取消收藏（根据用户ID和音乐ID）
    int deleteCollect(Integer userId, Integer musicId);

    // 查询用户的所有收藏
    List<Collect> findByUserId(Integer userId);
}