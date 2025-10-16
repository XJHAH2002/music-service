package com.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // 强制指定 .mp3 文件的 Content-Type 为 audio/mpeg
        configurer.mediaType("mp3", MediaType.valueOf("audio/mpeg"));
    }
}