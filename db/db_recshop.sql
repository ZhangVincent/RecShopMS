/*
 Navicat MySQL Data Transfer

 Source Server         : MySQLzkp
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : db_recshop

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 30/03/2023 10:13:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_basic_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_basic_info`;
CREATE TABLE `tb_basic_info`  (
  `basic_info_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评估类目ID',
  `basic_info_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评估类目名称',
  `basic_info_status` int(0) NULL DEFAULT NULL COMMENT '评估类目启用状态（1启用，0停用）',
  PRIMARY KEY (`basic_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand`  (
  `brand_id` int(0) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `brand_logo` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '品牌logo',
  `brand_desc` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '品牌描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '加入时间',
  `brand_status` int(0) NULL DEFAULT NULL COMMENT '品牌状态（1启用，0停用）',
  PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_brand_good
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand_good`;
CREATE TABLE `tb_brand_good`  (
  `brand_good_id` int(0) NOT NULL AUTO_INCREMENT,
  `fk_brand_id` int(0) NULL DEFAULT NULL,
  `fk_good_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`brand_good_id`) USING BTREE,
  INDEX `fk_brand_id`(`fk_brand_id`) USING BTREE,
  INDEX `fk_good_id`(`fk_good_id`) USING BTREE,
  CONSTRAINT `tb_brand_good_ibfk_1` FOREIGN KEY (`fk_brand_id`) REFERENCES `tb_brand` (`brand_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_brand_good_ibfk_2` FOREIGN KEY (`fk_good_id`) REFERENCES `tb_good` (`good_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart`  (
  `cart_id` int(0) NOT NULL AUTO_INCREMENT,
  `fk_cart_user_id` int(0) NULL DEFAULT NULL,
  `fk_cart_good_id` int(0) NULL DEFAULT NULL,
  `cart_good_price` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE,
  INDEX `fk_cart_user_id`(`fk_cart_user_id`) USING BTREE,
  INDEX `fk_cart_good_id`(`fk_cart_good_id`) USING BTREE,
  CONSTRAINT `tb_cart_ibfk_1` FOREIGN KEY (`fk_cart_user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_cart_ibfk_2` FOREIGN KEY (`fk_cart_good_id`) REFERENCES `tb_good` (`good_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 480 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_cart_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart_detail`;
CREATE TABLE `tb_cart_detail`  (
  `cart_detail_id` int(0) NOT NULL AUTO_INCREMENT,
  `fk_cart_id` int(0) NULL DEFAULT NULL,
  `fk_info_detail_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_detail_id`) USING BTREE,
  INDEX `fk_cart_id`(`fk_cart_id`) USING BTREE,
  INDEX `fk_info_detail_id`(`fk_info_detail_id`) USING BTREE,
  CONSTRAINT `tb_cart_detail_ibfk_1` FOREIGN KEY (`fk_cart_id`) REFERENCES `tb_cart` (`cart_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_cart_detail_ibfk_2` FOREIGN KEY (`fk_info_detail_id`) REFERENCES `tb_info_detail` (`info_detail_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5259 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `category_id` int(0) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `category_icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '类别图标',
  `category_status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '类别状态（1启用，0停用）',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_category_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_category_brand`;
CREATE TABLE `tb_category_brand`  (
  `category_brand_id` int(0) NOT NULL AUTO_INCREMENT,
  `fk_category_id` int(0) NULL DEFAULT NULL,
  `fk_brand_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`category_brand_id`) USING BTREE,
  INDEX `fk_category_id`(`fk_category_id`) USING BTREE,
  INDEX `fk_brand_id`(`fk_brand_id`) USING BTREE,
  CONSTRAINT `tb_category_brand_ibfk_1` FOREIGN KEY (`fk_category_id`) REFERENCES `tb_category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_category_brand_ibfk_2` FOREIGN KEY (`fk_brand_id`) REFERENCES `tb_brand` (`brand_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_comments
-- ----------------------------
DROP TABLE IF EXISTS `tb_comments`;
CREATE TABLE `tb_comments`  (
  `comment_id` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'ID',
  `good_id` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商品id',
  `good_name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `order_item_id` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '订单项(商品快照)ID 可为空',
  `user_id` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评论用户id 用户名须脱敏',
  `is_anonymous` int(0) NULL DEFAULT NULL COMMENT '是否匿名（1:是，0:否）',
  `comment_type` int(0) NULL DEFAULT NULL COMMENT '评价类型（1好评，0中评，-1差评）',
  `comment_level` int(0) NOT NULL COMMENT '评价等级 1：好评 2：中评 3：差评',
  `comment_content` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评价内容',
  `comment_imgs` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评价晒图(JSON {img1:url1,img2:url2}  )',
  `sepc_name` datetime(0) NULL DEFAULT NULL COMMENT '评价时间 可为空',
  `reply_status` int(0) NULL DEFAULT NULL COMMENT '是否回复（0:未回复，1:已回复）',
  `reply_content` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `is_show` int(0) NULL DEFAULT NULL COMMENT '是否显示（1:是，0:否）',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '商品评价 ' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_good
-- ----------------------------
DROP TABLE IF EXISTS `tb_good`;
CREATE TABLE `tb_good`  (
  `good_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `good_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商品名称',
  `good_img` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `good_cost` int(0) NULL DEFAULT NULL COMMENT '参考回收价',
  `good_min_price` int(0) NULL DEFAULT NULL COMMENT '最低回收价',
  `good_first_price` int(0) NULL DEFAULT NULL,
  `good_second_price` int(0) NULL DEFAULT NULL,
  `good_third_price` int(0) NULL DEFAULT NULL,
  `good_forth_price` int(0) NULL DEFAULT NULL,
  `good_fifth_price` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`good_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_good_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_good_detail`;
CREATE TABLE `tb_good_detail`  (
  `gd_id` int(0) NOT NULL AUTO_INCREMENT,
  `fk_good_id` int(0) NULL DEFAULT NULL COMMENT '商品ID',
  `fk_info_detail_id` int(0) NULL DEFAULT NULL COMMENT '评估项',
  `good_discount` int(0) NULL DEFAULT NULL COMMENT '对应评估项加权(正数表示选中扣减价格)',
  PRIMARY KEY (`gd_id`) USING BTREE,
  INDEX `fk_info_detail_id`(`fk_info_detail_id`) USING BTREE,
  CONSTRAINT `tb_good_detail_ibfk_1` FOREIGN KEY (`fk_info_detail_id`) REFERENCES `tb_info_detail` (`info_detail_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 306 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_info_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_info_detail`;
CREATE TABLE `tb_info_detail`  (
  `info_detail_id` int(0) NOT NULL AUTO_INCREMENT,
  `info_detail_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `info_detail_desc` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `fk_basic_info_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`info_detail_id`) USING BTREE,
  INDEX `fk_basic_info_id`(`fk_basic_info_id`) USING BTREE,
  CONSTRAINT `tb_info_detail_ibfk_1` FOREIGN KEY (`fk_basic_info_id`) REFERENCES `tb_basic_info` (`basic_info_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_login_logs
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_logs`;
CREATE TABLE `tb_login_logs`  (
  `log_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `log_text` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '登录状态',
  `log_addr` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '登录地址',
  `log_mgrname` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '登录用户名',
  `log_host` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '客户端IP',
  `log_time` timestamp(0) NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_managers
-- ----------------------------
DROP TABLE IF EXISTS `tb_managers`;
CREATE TABLE `tb_managers`  (
  `mgr_id` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员编号、工号',
  `login_name` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员登录名',
  `login_pwd` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员登录密码',
  `mgr_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员姓名',
  `mgr_gender` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员性别',
  `mgr_tel` char(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员手机号码',
  `mgr_email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员邮箱',
  `mgr_qq` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员QQ',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`mgr_id`) USING BTREE,
  UNIQUE INDEX `login_name`(`login_name`) USING BTREE,
  UNIQUE INDEX `mgr_tel`(`mgr_tel`) USING BTREE,
  UNIQUE INDEX `mgr_email`(`mgr_email`) USING BTREE,
  UNIQUE INDEX `mgr_qq`(`mgr_qq`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_menus
-- ----------------------------
DROP TABLE IF EXISTS `tb_menus`;
CREATE TABLE `tb_menus`  (
  `menu_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `menu_code` varchar(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '菜单编码',
  `menu_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '菜单名称',
  `menu_order` int(0) NOT NULL COMMENT '菜单排序序号',
  `menu_level` int(0) NOT NULL COMMENT '菜单级别',
  `menu_icon` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '一级菜单图标',
  `parent_menu_code` varchar(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '父级菜单编码',
  `menu_url` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '点击菜单请求的链接url',
  `menu_state` int(0) NOT NULL COMMENT '菜单状态： 1 启用，0 停用',
  PRIMARY KEY (`menu_id`) USING BTREE,
  UNIQUE INDEX `menu_code`(`menu_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_mgr_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_mgr_role`;
CREATE TABLE `tb_mgr_role`  (
  `mgr_id` char(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `role_id` int(0) NOT NULL,
  PRIMARY KEY (`mgr_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_order_items
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_items`;
CREATE TABLE `tb_order_items`  (
  `item_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '快照ID',
  `order_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '订单编号',
  `good_id` int(0) NOT NULL COMMENT '商品ID',
  `good_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商品名称',
  `good_img_path` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商品图片',
  `good_info` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商品评估项目',
  `good_price` int(0) NOT NULL COMMENT '商品评估价格',
  `is_comment` int(0) NOT NULL COMMENT '评价状态：0 未评价  1 已评价',
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_orders
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders`;
CREATE TABLE `tb_orders`  (
  `order_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '订单编号',
  `user_id` int(0) NOT NULL COMMENT '用户ID',
  `order_total_price` int(0) NOT NULL COMMENT '订单总价格',
  `user_addr` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户地址信息',
  `user_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户姓名',
  `user_tel` char(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户电话',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `order_desc` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '订单备注',
  `retrieve_type` int(0) NOT NULL COMMENT '回收类型: 1 快递， 2 上门验收',
  `order_status` int(0) NOT NULL COMMENT '订单状态：1 新订单，2 待指派，3 已指派，4 已完成，5 已关闭，6 用户已寄出，7 平台验收中，8 验收通过，9 待退回，10 已退回，11 用户已取消',
  `send_logistics_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '寄送物流名称',
  `send_logistics_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '寄送物流单号',
  `order_processor` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '订单指派处理人',
  `back_text` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '退回原因',
  `back_logistics_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '退回物流名称',
  `back_logistics_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '退回物流单号',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu`  (
  `role_id` int(0) NOT NULL,
  `menu_id` int(0) NOT NULL,
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_roles
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles`;
CREATE TABLE `tb_roles`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色说明',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `role_name`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_systemlogs
-- ----------------------------
DROP TABLE IF EXISTS `tb_systemlogs`;
CREATE TABLE `tb_systemlogs`  (
  `log_id` int(0) NOT NULL AUTO_INCREMENT,
  `mgr_id` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `log_content` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `log_time` timestamp(0) NOT NULL,
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_systemparam
-- ----------------------------
DROP TABLE IF EXISTS `tb_systemparam`;
CREATE TABLE `tb_systemparam`  (
  `systemparam_id` int(0) NOT NULL AUTO_INCREMENT,
  `systemparam_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `systemparam_value` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`systemparam_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `user_password` char(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `user_salt` char(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 683 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
