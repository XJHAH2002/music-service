package com.music.mapper;

import com.music.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CategoryMapper {
    // 获取所有分类
    List<Category> findAll();
}