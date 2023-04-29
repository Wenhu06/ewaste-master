/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50728 (5.7.28-log)
 Source Host           : localhost:3306
 Source Schema         : ewaste

 Target Server Type    : MySQL
 Target Server Version : 50728 (5.7.28-log)
 File Encoding         : 65001

 Date: 12/03/2023 20:08:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_data
-- ----------------------------
DROP TABLE IF EXISTS `device_data`;
CREATE TABLE `device_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_recycle_id` bigint(20) NULL DEFAULT 0,
  `oss_url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `access` int(11) NULL DEFAULT 0 COMMENT 'could download or not',
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_data
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
