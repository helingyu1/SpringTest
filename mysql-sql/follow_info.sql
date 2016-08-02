# Host: 127.0.0.1  (Version 5.6.24)
# Date: 2016-08-02 08:43:37
# Generator: MySQL-Front 5.3  (Build 5.31)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "follow_info"
#

CREATE TABLE `follow_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `target` varchar(55) DEFAULT NULL COMMENT '被关注用户id',
  `fans` varchar(56) DEFAULT NULL COMMENT '粉丝id',
  `Gid` int(11) DEFAULT NULL COMMENT '所属关注分组id',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='关注与粉丝表';

#
# Data for table "follow_info"
#

INSERT INTO `follow_info` VALUES (1,'xiayuqing','helingyu',NULL),(6,'helingyu1','helingyu',NULL),(7,'helingyu2','helingyu',NULL),(8,'helingyu3','helingyu',NULL),(9,'helingyu4','helingyu',NULL),(10,'大大','蛋花汤汤',NULL);
