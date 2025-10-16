# 🎵 Music Service

音乐服务平台后端服务，基于 Spring Boot 构建，提供音乐播放、收藏、评论等核心功能的 RESTful API。

## 📋 项目概述

这是一个音乐服务平台的后端服务，支持用户注册登录、音乐播放、收藏管理、评论互动等功能。项目采用 Spring Boot + MyBatis 技术栈，连接 MySQL 数据库存储数据。

## 🛠 技术栈

- ☕ Java 8
- 🚀 Spring Boot 2.7.6
- 🗃 MyBatis
- 🛢 MySQL
- 📦 Maven

## 🎯 功能模块

### 👤 用户管理
- 📝 用户注册/登录
- ✏️ 用户信息修改
- 🔐 密码修改

### 🎵 音乐管理
- 📋 获取所有音乐列表
- 🔍 音乐搜索功能
- 🕓 音乐播放记录

### ❤️ 收藏管理
- ➕ 添加收藏
- ➖ 取消收藏
- 📂 获取用户收藏列表

### 💬 评论管理
- 📝 发布评论
- 👀 查看音乐评论
- 👍 评论点赞
- 🗑 删除评论(支持管理员权限)
- 📌 评论置顶(仅管理员)

### 📁 文件上传
- 😊 头像上传
- 🎵 音乐文件上传
- 🖼 专辑封面上传

## 📁 项目结构

```
src/
├── main/
│   ├── java/
│   │   └── com/music/
│   │       ├── config/       # 配置类(跨域、文件上传、Web配置)
│   │       ├── controller/   # 控制器层
│   │       ├── entity/       # 实体类
│   │       ├── mapper/       # 数据访问层
│   │       ├── service/      # 业务逻辑层
│   │       └── MusicServiceApplication.java # 启动类
│   └── resources/
│       ├── mapper/          # MyBatis映射文件
│       └── application.yml  # 配置文件
└── test/                    # 测试文件
```

## ⚙️ 配置说明

### 🛢 数据库配置
在 `src/main/resources/application.yml` 中配置数据库连接：

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/music_db?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC
    username: root  # 你的 MySQL 用户名
    password: 123456  # 你的 MySQL 密码
```

### 📁 文件上传配置
文件上传路径配置在 [UploadConfig.java](file:///F:/Study/JAVA%20Full%20Stack/music-service/src/main/java/com/music/config/UploadConfig.java) 和 [UploadController.java](file:///F:/Study/JAVA%20Full%20Stack/music-service/src/main/java/com/music/controller/UploadController.java) 中，默认路径为 `D:/music-upload/`，请确保该目录存在。

## 🌐 API 接口

### 👤 用户相关接口
- `POST /register` - 用户注册
- `POST /login` - 用户登录
- `POST /update/info` - 更新用户信息
- `POST /update/password` - 修改密码

### 🎵 音乐相关接口
- `GET /music/all` - 获取所有音乐
- `GET /music/search?keyword=关键词` - 搜索音乐

### ❤️ 收藏相关接口
- `POST /collect/add` - 添加收藏
- `POST /collect/delete` - 取消收藏
- `GET /collect/user?userId=用户ID` - 获取用户收藏列表

### 💬 评论相关接口
- `POST /comment/add` - 添加评论
- `GET /comment/music/{musicId}` - 获取音乐评论
- `POST /comment/like/{id}` - 点赞评论
- `POST /comment/delete?id=评论ID&userId=用户ID&role=角色` - 删除评论
- `POST /comment/top?id=评论ID&isTop=是否置顶&role=角色` - 置顶评论

### 📁 文件上传接口
- `POST /upload/avatar` - 上传头像
- `POST /upload/music` - 上传音乐

## 🚀 部署说明

1. 确保已安装 Java 8+ 和 MySQL
2. 创建数据库 `music_db` 并导入 `src/music_db.sql` 文件
3. 修改 `application.yml` 中的数据库连接配置
4. 在项目根目录下运行命令启动项目：

```bash
mvn spring-boot:run
```

或者打包后运行：

```bash
mvn clean package
java -jar target/music-service-0.0.1-SNAPSHOT.jar
```

## 🔧 跨域配置

项目已配置允许来自 `http://localhost:5173` 的跨域请求，如需修改请编辑 [CorsConfig.java](file:///F:/Study/JAVA%20Full%20Stack/music-service/src/main/java/com/music/config/CorsConfig.java) 文件。