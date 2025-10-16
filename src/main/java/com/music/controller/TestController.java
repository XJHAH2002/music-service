package com.music.controller;  // 包名必须和文件夹对应，不要改

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 标记这是一个接口类，能被前端访问
public class TestController {

    // 定义一个GET请求接口，访问路径是 /test
    @GetMapping("/test")
    public String test() {
        return "测试接口成功！";  // 访问时返回这句话
    }
}