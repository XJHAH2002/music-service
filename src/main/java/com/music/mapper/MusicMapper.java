package com.music.mapper;

import com.music.entity.Music;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MusicMapper {
    // 查询所有音乐
    List<Music> findAll();

    // 根据关键词搜索音乐（按歌名或歌手）
    List<Music> search(String keyword);
}