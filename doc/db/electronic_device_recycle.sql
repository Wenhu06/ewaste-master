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

 Date: 12/03/2023 20:08:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for electronic_device_recycle
-- ----------------------------
DROP TABLE IF EXISTS `electronic_device_recycle`;
CREATE TABLE `electronic_device_recycle`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productId` bigint(20) NULL DEFAULT 0,
  `userId` int(11) NULL DEFAULT 0,
  `price` double NULL DEFAULT 0,
  `device_type` int(11) NULL DEFAULT 0,
  `quality` int(11) NULL DEFAULT 0,
  `hidden` int(11) NULL DEFAULT 1 COMMENT '0: hidden 1:visible',
  `estimate_value` double NULL DEFAULT 0,
  `upload_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pic_url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of electronic_device_recycle
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
