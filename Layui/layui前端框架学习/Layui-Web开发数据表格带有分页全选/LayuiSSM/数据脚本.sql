/*
Navicat MySQL Data Transfer

Source Server         : aa
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : day1

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-07-20 18:21:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `uid` int(11) NOT NULL auto_increment,
  `uname` varchar(30) NOT NULL,
  `usex` char(2) NOT NULL,
  `uage` int(100) NOT NULL,
  `uaddress` varchar(50) NOT NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO userinfo VALUES ('3', '丽丽', '女', '23', '河南省郑州市');
INSERT INTO userinfo VALUES ('7', 'llksa莱克斯顿', '男', '22', '河南省许昌市23');
INSERT INTO userinfo VALUES ('9', '卡萨丁', '男', '34', '卡世纪东方卡');
INSERT INTO userinfo VALUES ('10', '开发了', '女', '44', '卡死的浪费');
INSERT INTO userinfo VALUES ('12', '来看待', '男', '33', '家世纪东方');
INSERT INTO userinfo VALUES ('13', '拉伸', '女', '22', '刻录机阿斯蒂芬');
INSERT INTO userinfo VALUES ('14', '卡时间段', '女', '55', '卡萨丁 拉斯卡京东方');
INSERT INTO userinfo VALUES ('15', '开始', '男', '66', '卡接收到卡萨丁');
INSERT INTO userinfo VALUES ('16', '抗衰老事', '男', '77', '加速度计卡');
INSERT INTO userinfo VALUES ('17', '卡萨丁', '男', '43', '卡三等奖');
INSERT INTO userinfo VALUES ('18', '开始角', '男', '88', '卡萨丁路口撒旦教');
INSERT INTO userinfo VALUES ('19', '那老师', '男', '45', '凯撒的扩散');
INSERT INTO userinfo VALUES ('20', '难落实到', '男', '42', '卡萨丁沙拉贷款');
INSERT INTO userinfo VALUES ('21', '那棵树', '男', '34', '拉家带口');
INSERT INTO userinfo VALUES ('22', '卡萨丁', '男', '34', '卡萨的积分');
INSERT INTO userinfo VALUES ('23', '卡萨丁仨', '男', '23', '卡萨丁开始了');
INSERT INTO userinfo VALUES ('24', '乱说的', '男', '44', '路口撒的发生');



update userinfo set uname = , usex = , uage = , uaddress = , where uid = ?	


delete from userinfo where uid = ?

select * from userinfo limit ((page - 1)*limit),limit;

select * from userinfo limit 0,10;
