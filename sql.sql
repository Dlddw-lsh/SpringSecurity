/*
 Navicat Premium Data Transfer

 Source Server         : lsh
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : rbacdemo

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 13/04/2024 21:20:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int NOT NULL,
  `parent_id` int NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限字段',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由name',
  `menu_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '跳转路径',
  `route_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由path',
  `component_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径',
  `type` tinyint(1) NOT NULL COMMENT '类型(0 目录 1 菜单 2 按钮)',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `parent_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '上级菜单名称',
  `order_num` int NULL DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`menu_id`, `type`) USING BTREE,
  INDEX `menu_id`(`menu_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', 'sys:system:index', 'system', '/sys', '/sys', NULL, 0, 'SettingFilled', NULL, 1);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', 'sys:user:index', 'sysUserList', '/sys/userList', 'userList', '/sys/userList', 1, 'TeamOutlined', '系统管理', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'sys:role:index', 'sysRoleList', '/sys/roleList', 'roleList', '/sys/roleList', 1, 'CommentOutlined', '系统管理', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'sys:menu:index', 'sysMenuList', '/sys/menuList', 'menuList', '/sys/menuList', 1, 'FolderOutlined', '系统管理', 3);
INSERT INTO `sys_menu` VALUES (5, 2, '新增', 'sys:user:add', NULL, NULL, NULL, NULL, 2, '', '用户管理', 1);
INSERT INTO `sys_menu` VALUES (6, 2, '删除', 'sys:user:delete', NULL, NULL, NULL, NULL, 2, '', '用户管理', 2);
INSERT INTO `sys_menu` VALUES (7, 2, '编辑', 'sys:user:update', NULL, NULL, NULL, NULL, 2, '', '用户管理', 3);
INSERT INTO `sys_menu` VALUES (8, 3, '新增', 'sys:role:add', NULL, NULL, NULL, NULL, 2, '', '角色管理', 1);
INSERT INTO `sys_menu` VALUES (9, 3, '删除', 'sys:role:delete', NULL, NULL, NULL, NULL, 2, '', '角色管理', 2);
INSERT INTO `sys_menu` VALUES (10, 3, '编辑', 'sys:role:update', NULL, NULL, NULL, NULL, 2, '', '角色管理', 3);
INSERT INTO `sys_menu` VALUES (11, 4, '新增', 'sys:menu:add', NULL, NULL, NULL, NULL, 2, '', '菜单管理', 1);
INSERT INTO `sys_menu` VALUES (12, 4, '删除', 'sys:menu:delete', NULL, NULL, NULL, NULL, 2, '', '菜单管理', 2);
INSERT INTO `sys_menu` VALUES (13, 4, '编辑', 'sys:menu:update', NULL, NULL, NULL, NULL, 2, '', '菜单管理', 3);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', '1');
INSERT INTO `sys_role` VALUES (2, 'student', '学生', '2');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_menu_id` int NOT NULL,
  `menu_id` int NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`role_menu_id`) USING BTREE,
  INDEX `menu_id`(`menu_id` ASC) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE,
  CONSTRAINT `sys_role_menu_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sys_role_menu_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2, 1);
INSERT INTO `sys_role_menu` VALUES (3, 3, 1);
INSERT INTO `sys_role_menu` VALUES (4, 4, 1);
INSERT INTO `sys_role_menu` VALUES (5, 5, 1);
INSERT INTO `sys_role_menu` VALUES (6, 6, 1);
INSERT INTO `sys_role_menu` VALUES (7, 7, 1);
INSERT INTO `sys_role_menu` VALUES (8, 8, 1);
INSERT INTO `sys_role_menu` VALUES (9, 9, 1);
INSERT INTO `sys_role_menu` VALUES (10, 10, 1);
INSERT INTO `sys_role_menu` VALUES (11, 11, 1);
INSERT INTO `sys_role_menu` VALUES (12, 12, 1);
INSERT INTO `sys_role_menu` VALUES (13, 13, 1);
INSERT INTO `sys_role_menu` VALUES (14, 1, 2);
INSERT INTO `sys_role_menu` VALUES (15, 2, 2);
INSERT INTO `sys_role_menu` VALUES (16, 5, 2);
INSERT INTO `sys_role_menu` VALUES (17, 6, 2);
INSERT INTO `sys_role_menu` VALUES (18, 7, 2);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'test1', '$2a$10$N1OrVqfCGoa6IIhVa17EweY1WnLXXoZuP6kGkujvZRnf/REosUb5G');
INSERT INTO `sys_user` VALUES (2, 'test2', '$2a$10$N1OrVqfCGoa6IIhVa17EweY1WnLXXoZuP6kGkujvZRnf/REosUb5G');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_role_id` int NOT NULL,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_role_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE,
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
