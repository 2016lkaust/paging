# paging分页简单实现

# 数据库表
```sql
/*
Navicat MySQL Data Transfer

Source Server         : MINE
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-11 16:14:04
*/
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张一', '18');
INSERT INTO `user` VALUES ('2', '张二', '18');
INSERT INTO `user` VALUES ('3', '张三', '1');
INSERT INTO `user` VALUES ('4', '张四', '2');
INSERT INTO `user` VALUES ('5', '张五', '3');
INSERT INTO `user` VALUES ('6', '张六', '4');
INSERT INTO `user` VALUES ('7', '张七', '5');
INSERT INTO `user` VALUES ('8', '张八', '6');
INSERT INTO `user` VALUES ('9', '张九', '7');
INSERT INTO `user` VALUES ('10', '张十', '8');
INSERT INTO `user` VALUES ('11', '李一', '9');
INSERT INTO `user` VALUES ('12', '李二', '10');
INSERT INTO `user` VALUES ('13', '李三', '11');
INSERT INTO `user` VALUES ('14', '李四', '12');
INSERT INTO `user` VALUES ('15', '李五', '13');
INSERT INTO `user` VALUES ('16', '李六', '14');
INSERT INTO `user` VALUES ('17', '李七', '15');
INSERT INTO `user` VALUES ('18', '李八', '16');
INSERT INTO `user` VALUES ('19', '李九', '17');
INSERT INTO `user` VALUES ('20', '李十', '18');
INSERT INTO `user` VALUES ('21', '孙一', '19');
INSERT INTO `user` VALUES ('22', '孙二', '20');
INSERT INTO `user` VALUES ('23', '孙三', '21');
INSERT INTO `user` VALUES ('24', '孙四', '22');
INSERT INTO `user` VALUES ('25', '孙五', '23');
INSERT INTO `user` VALUES ('26', '孙六', '24');
INSERT INTO `user` VALUES ('27', '孙七', '25');
INSERT INTO `user` VALUES ('28', '孙八', '26');
```
