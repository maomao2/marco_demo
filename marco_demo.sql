/*
Navicat MySQL Data Transfer

Source Server         : 172.0.0.1
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : marco_demo

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-02-25 01:15:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` longtext COMMENT '内容',
  `author` varchar(32) DEFAULT NULL COMMENT '作者',
  `hot_count` int(11) NOT NULL DEFAULT '0',
  `ident_name` varchar(32) NOT NULL COMMENT '唯一标识',
  `category_id` int(11) DEFAULT NULL COMMENT '分类ID',
  `keyword` varchar(255) DEFAULT NULL COMMENT '关键字',
  `status` int(3) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，2：已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `article_ident_name_uk` (`ident_name`),
  KEY `article_authorid_key` (`author`),
  KEY `article_cfid_fk` (`category_id`),
  CONSTRAINT `article_cfid_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('48', '测试标题11111111111', '测试内容', '伟哥', '0', 'test', null, null, '1', '2019-02-25 00:48:04', '2019-02-25 01:03:29');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ident_name` varchar(255) DEFAULT NULL COMMENT '分类唯一标识',
  `class_name` varchar(255) DEFAULT NULL COMMENT '分类名',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `class_ident_name_uk` (`ident_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `permission_code` varchar(255) DEFAULT NULL COMMENT '权限代码',
  `uri` varchar(100) DEFAULT NULL,
  `sort` tinyint(3) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `type` tinyint(2) NOT NULL COMMENT '菜单类型，0，根菜单，1：子菜单，2：功能',
  `show` bit(1) DEFAULT b'1' COMMENT '是否显示（如果为功能菜单，建议不显示）',
  `desc` varchar(255) DEFAULT NULL COMMENT '菜单描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_menu_permission_code_uk` (`permission_code`) USING HASH,
  KEY `uri` (`uri`),
  KEY `sys_menu_parent_id_fk` (`parent_id`),
  CONSTRAINT `sys_menu_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(32) NOT NULL COMMENT '角色编码',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission` varchar(255) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `sys_role_permission_roleid_fk` (`role_id`),
  KEY `sys_role_permission_pcode_fk` (`permission`),
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`permission`) REFERENCES `sys_menu` (`permission_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `user_name` varchar(64) NOT NULL,
  `password` varchar(128) NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tc_account_user_name_uk` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='后台用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('7', 'admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', null, '2019-02-25 00:31:18', '2019-02-25 00:31:21');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_role_uid_fk` (`uid`),
  KEY `user_role_roleid_fk` (`role_id`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
