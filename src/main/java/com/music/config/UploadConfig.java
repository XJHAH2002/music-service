package com.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadConfig implements WebMvcConfigurer {
    // 配置静态资源访问路径（上传的文件放这里）
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 本地路径：D:/music-upload/（需手动创建该文件夹）
        String uploadPath = "file:D:/music-upload/";
        // 映射URL路径：http://localhost:8080/upload/** 访问本地文件
        registry.addResourceHandler("/upload/**")
                .addResourceLocations(uploadPath);
    }
}