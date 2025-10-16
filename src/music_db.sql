/*
Navicat MySQL Data Transfer

Source Server         : A
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : music_db

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2025-10-16 20:45:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '作者/歌手名称',
  `avatar` varchar(200) DEFAULT NULL COMMENT '作者头像路径',
  `intro` text COMMENT '作者简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', 'Sou', null, null);
INSERT INTO `author` VALUES ('2', 'Beyond', null, null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '分类名称（如流行、摇滚）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('3', '古典');
INSERT INTO `category` VALUES ('4', '嘻哈');
INSERT INTO `category` VALUES ('2', '摇滚');
INSERT INTO `category` VALUES ('1', '流行');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `music_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `category_id` int(11) DEFAULT NULL COMMENT '关联收藏分类ID（默认null表示“默认收藏夹”）',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `music_id` (`music_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `collect_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `collect_ibfk_2` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`),
  CONSTRAINT `collect_ibfk_3` FOREIGN KEY (`category_id`) REFERENCES `collect_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('6', '2', '2', '2025-10-15 21:16:00', null);
INSERT INTO `collect` VALUES ('7', '2', '3', '2025-10-15 21:16:00', null);
INSERT INTO `collect` VALUES ('8', '5', '1', '2025-10-16 18:50:06', null);
INSERT INTO `collect` VALUES ('9', '5', '2', '2025-10-16 18:50:07', null);
INSERT INTO `collect` VALUES ('10', '5', '3', '2025-10-16 18:50:07', null);

-- ----------------------------
-- Table structure for collect_category
-- ----------------------------
DROP TABLE IF EXISTS `collect_category`;
CREATE TABLE `collect_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '所属用户ID',
  `name` varchar(50) NOT NULL COMMENT '收藏夹名称（如“最爱华语”）',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `collect_category_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect_category
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `music_id` int(11) NOT NULL COMMENT '关联音乐ID',
  `user_id` int(11) NOT NULL COMMENT '评论用户ID',
  `content` text NOT NULL COMMENT '评论内容',
  `parent_id` int(11) DEFAULT NULL COMMENT '父评论ID（回复时不为null）',
  `like_count` int(11) DEFAULT '0' COMMENT '点赞数',
  `is_top` tinyint(4) DEFAULT '0' COMMENT '是否置顶（0-否，1-是，管理员操作）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `music_id` (`music_id`),
  KEY `user_id` (`user_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`parent_id`) REFERENCES `comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `url` varchar(200) NOT NULL,
  `cover` varchar(200) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL COMMENT '关联分类ID',
  `author_id` int(11) NOT NULL COMMENT '关联作者ID',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `music_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('1', 'ハレハレヤ（翻自 Flower）', '/music/Sou - ハレハレヤ（翻自 Flower）.mp3', '/cover/ハレハレヤ（翻自 Flower).jpg', null, null, '0');
INSERT INTO `music` VALUES ('2', '心做し', '/music/Sou - 心做し.mp3', '/cover/心做し..jpg', '4', null, '0');
INSERT INTO `music` VALUES ('3', 'いすぼくろ - 命ばっかり.mp3', '/music/Sou,いすぼくろ - 命ばっかり.mp3', '/cover/', '1', null, '0');

-- ----------------------------
-- Table structure for play_history
-- ----------------------------
DROP TABLE IF EXISTS `play_history`;
CREATE TABLE `play_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `music_id` int(11) NOT NULL COMMENT '音乐ID',
  `play_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '播放时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `music_id` (`music_id`),
  CONSTRAINT `play_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `play_history_ibfk_2` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of play_history
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `avatar` varchar(200) DEFAULT NULL COMMENT '用户头像路径',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `role` varchar(20) DEFAULT 'user' COMMENT '角色（user-普通用户，admin-管理员）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '艾向超', 'c6036a69be21cb660499b75718a3ef24', null, '2025-10-13 01:01:42', null, null, 'user');
INSERT INTO `user` VALUES ('3', '李白', 'c6036a69be21cb660499b75718a3ef24', null, '2025-10-15 19:20:30', null, null, 'user');
INSERT INTO `user` VALUES ('5', '杜甫', 'c6036a69be21cb660499b75718a3ef24', null, '2025-10-16 18:50:01', null, null, 'user');

-- ----------------------------
-- Table structure for verification_code
-- ----------------------------
DROP TABLE IF EXISTS `verification_code`;
CREATE TABLE `verification_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `code` varchar(10) NOT NULL COMMENT '验证码',
  `expire_time` datetime NOT NULL COMMENT '过期时间（如10分钟后）',
  `type` varchar(20) NOT NULL COMMENT '类型（register-注册，reset-重置密码）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verification_code
-- ----------------------------
