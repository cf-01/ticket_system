/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : ticket_system

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 17/11/2023 22:32:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `show_id` int NULL DEFAULT NULL,
  `buy_num` int NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '已使用，未使用，已退票',
  `use_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `buy_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sum_price` decimal(10, 2) NULL DEFAULT NULL,
  `show_time` datetime NULL DEFAULT NULL COMMENT '入场时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (2, 2, 3, 2, '2023-11-16 14:50:27', '1', '橙灰', '18470558967', '362203200109147922', '橙灰', 400.00, '2023-11-17 00:00:00');
INSERT INTO `t_order` VALUES (5, 2, 4, 1, '2023-11-16 21:48:33', '3', '呼呼呼', '18470558967', '394857602948572832', '用户1', 100.00, '2023-11-17 00:00:00');
INSERT INTO `t_order` VALUES (6, 2, 3, 5, '2023-11-16 21:49:07', '0', '急急急', '18475930586', '21904870923784097', '用户1', 1000.00, '2023-11-17 00:00:00');
INSERT INTO `t_order` VALUES (8, 8, 3, 2, '2023-11-16 22:45:37', '0', '黄程', '18470558967', '362203200209147912', '用户', 400.00, '2023-11-17 00:00:00');
INSERT INTO `t_order` VALUES (9, 8, 5, 1, '2023-11-16 22:59:09', '0', '程', '18458395048', '362203200109147912', '用户', 50.00, '2023-11-17 00:00:00');
INSERT INTO `t_order` VALUES (11, 9, 3, 2, '2023-11-17 22:11:30', '3', 'huahau', '13979558694', '362202300006087941', '用户', 400.00, '2023-11-16 00:00:00');

-- ----------------------------
-- Table structure for t_show
-- ----------------------------
DROP TABLE IF EXISTS `t_show`;
CREATE TABLE `t_show`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ticket_num` int NULL DEFAULT NULL,
  `show_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '0代表已经废弃，1代表正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_show
-- ----------------------------
INSERT INTO `t_show` VALUES (3, '科技馆', '科技馆', 89, '2023-11-16', 200.00, '2023-11-17 14:37:31', '2023-11-17 14:37:31', 1);
INSERT INTO `t_show` VALUES (4, '历史馆', '历史馆', 16, '2023-11-16', 100.00, '2023-11-17 14:47:13', '2023-11-17 14:47:13', 1);
INSERT INTO `t_show` VALUES (5, '动物馆', '动物馆', 0, '2023-11-17', 50.00, '2023-11-17 00:00:34', '2023-11-17 22:58:35', 1);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account_unique`(`account` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '管理员', '123456', NULL, '2023-11-09 11:58:54', '2023-11-09 11:58:54');
INSERT INTO `t_user` VALUES (2, 'user1', '用户1', '123456', NULL, '2023-11-09 11:59:49', '2023-11-09 11:59:49');
INSERT INTO `t_user` VALUES (8, 'user2', '用户', '123456', '18470558967', '2023-11-16 22:13:43', '2023-11-16 22:13:43');
INSERT INTO `t_user` VALUES (9, 'user3', '用户', '123456', '13979558759', '2023-11-17 22:09:11', '2023-11-17 22:09:11');

SET FOREIGN_KEY_CHECKS = 1;
