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

 Date: 20/04/2023 23:20:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_id` int(11) NULL DEFAULT 0 COMMENT 'category id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'name',
  `pic_url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'picture url',
  `release_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'device release time',
  `price` int(11) NULL DEFAULT 0 COMMENT 'price',
  `creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'creator name',
  `creator_id` bigint(20) NULL DEFAULT NULL COMMENT 'creator id',
  `gmt_created` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `last_operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'last modify user name',
  `last_operator_id` bigint(20) NULL DEFAULT NULL COMMENT 'last modify user id',
  `gmt_modified` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  `is_deleted` int(11) NULL DEFAULT 0 COMMENT 'logic delete',
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'description',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'device table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 0, 'Apple', '', '2023-04-21 05:41:03', 600, '', NULL, '2023-04-21 05:41:03', '', NULL, '2023-04-21 05:41:03', 0, '');

SET FOREIGN_KEY_CHECKS = 1;
