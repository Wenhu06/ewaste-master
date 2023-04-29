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

 Date: 12/03/2023 20:08:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for electronic_device_recycle_order
-- ----------------------------
DROP TABLE IF EXISTS `electronic_device_recycle_order`;
CREATE TABLE `electronic_device_recycle_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_recycle_id` bigint(20) NULL DEFAULT 0,
  `type` int(11) NULL DEFAULT 0 COMMENT 'upload or download',
  `status` int(11) NULL DEFAULT 0,
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of electronic_device_recycle_order
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
