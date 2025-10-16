package com.music.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

@RestController
public class UploadController {
    // 上传路径（与UploadConfig一致）
    private static final String UPLOAD_PATH = "D:/music-upload/";

    // 上传头像
    @PostMapping("/upload/avatar")
    public String uploadAvatar(@RequestParam MultipartFile file) {
        return uploadFile(file, "avatar/"); // 头像放avatar子文件夹
    }

    // 上传音乐
    @PostMapping("/upload/music")
    public String uploadMusic(@RequestParam MultipartFile file) {
        return uploadFile(file, "music/"); // 音乐放music子文件夹
    }

    // 通用上传方法
    private String uploadFile(MultipartFile file, String subDir) {
        try {
            // 创建文件夹
            File dir = new File(UPLOAD_PATH + subDir);
            if (!dir.exists()) dir.mkdirs();
            // 生成唯一文件名（避免重复）
            String fileName = UUID.randomUUID() + "." +
                    file.getOriginalFilename().split("\\.")[1];
            // 保存文件
            file.transferTo(new File(dir, fileName));
            // 返回访问URL（如/upload/avatar/xxx.jpg）
            return "/upload/" + subDir + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
    }
}