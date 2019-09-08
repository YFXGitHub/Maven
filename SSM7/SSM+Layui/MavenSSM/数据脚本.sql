/*
Navicat MySQL Data Transfer

Source Server         : aa
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : day5

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-09-07 15:17:15
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `orders`
-- -------------------------------- 创建 订单表 
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL auto_increment,
  `oname` varchar(30) NOT NULL,
  `person` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `odesc` varchar(50) NOT NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO orders VALUES ('1', '猛犸1', '大法官1', '熊熊森林1', '这是一头好猛犸1', '2019-09-07 00:00:00');
INSERT INTO orders VALUES ('2', '猛犸2', '老实交代2', '熊熊森林2', '这是一头好猛犸2', '2019-09-07 00:00:00');
INSERT INTO orders VALUES ('3', '猛犸3', '快乐圣诞节', '熊熊森林3', '这是一头好猛犸3', '2019-09-07 00:00:00');
INSERT INTO orders VALUES ('4', '猛犸4', '的风口浪尖a', '熊熊森林fs', '这是一头好猛犸4', '2019-09-07 00:00:00');
INSERT INTO orders VALUES ('5', '猛犸5', '拉斯柯达', '熊熊森林5', '这是一头好猛犸5', '2019-09-07 00:00:00');
INSERT INTO orders VALUES ('6', '猛犸6', '撒旦法6', '熊熊森林6sd', '这是一头好猛犸6sd', '2019-09-07 00:00:00');
INSERT INTO orders VALUES ('7', 'sdfg', 'z是大法官2', '大概是地方', '阿是大法官的身份', '2019-09-07 14:23:15');
INSERT INTO orders VALUES ('8', '电饭锅a', '第三方asdf', '的说法sad盛世嫡妃asd', '撒的发撒的发生sdf', '2019-09-07 14:25:45');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------创建记录表 record
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL auto_increment,
  `person` varchar(30) NOT NULL,
  `function` varchar(30) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO record VALUES ('1', 'root', '修改', '2019-09-07');
INSERT INTO record VALUES ('2', 'root', '删除', '2019-09-07');
INSERT INTO record VALUES ('3', 'root', '修改用户', '2019-09-07');
INSERT INTO record VALUES ('4', 'root', '删除用户', '2019-09-07');
INSERT INTO record VALUES ('5', 'root', '添加订单', '2019-09-07');
INSERT INTO record VALUES ('6', 'root', '修改订单', '2019-09-07');
INSERT INTO record VALUES ('7', 'root', '删除订单', '2019-09-07');

-- ----------------------------
-- Table structure for `user`
-- ------------------------------ 创建用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL auto_increment,
  `uname` varchar(30) NOT NULL,
  `upwd` varchar(30) NOT NULL,
  `emial` varchar(30) NOT NULL,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'root', '123', '234234@qq.com', '12332112333');
INSERT INTO user VALUES ('2', 'sys', '321', 'asdf@sd.com', '32112332112');
INSERT INTO user VALUES ('3', 'admin', '222', '2342@qq.com', '12332112332');
INSERT INTO user VALUES ('4', 'sss', '1232', '2342@sas.com', '14321211233');
INSERT INTO user VALUES ('5', 'aaa', '123', '2342@sdf.com', '12332112321');
INSERT INTO user VALUES ('6', 'bbb', 'sss', '3463@dfg.com', '3452342322');
INSERT INTO user VALUES ('7', 'ccc', '345', 'skdf2.com', '3245231231');
INSERT INTO user VALUES ('8', 'ddd', '345', '3452@sdf.cn', '34523423443');
INSERT INTO user VALUES ('9', 'rets', '234s', '34523s@skdf.com', '23412323422');
INSERT INTO user VALUES ('10', 'kefssdf', '234', 'sdsdff@sd.com', '2342343111');
INSERT INTO user VALUES ('11', 'kjsdf', '3452', 'skdfj@.com', '23443223443');
INSERT INTO user VALUES ('14', 'askdfj', '234', 'kjsadf@2w.com', '12332112332');
INSERT INTO user VALUES ('15', 'lkjsadf', '34', 'aksdf@qq.com', '23423443223');
INSERT INTO user VALUES ('16', 'skdflk1', '234', 'kalsjdf@ss.com', '23421343211');
INSERT INTO user VALUES ('20', 'qq', '111', '45sadfk@qq.com', '12332112332');
