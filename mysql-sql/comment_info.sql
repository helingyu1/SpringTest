# Host: 127.0.0.1  (Version 5.6.24)
# Date: 2016-08-02 08:43:13
# Generator: MySQL-Front 5.3  (Build 5.31)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "comment_info"
#

CREATE TABLE `comment_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `b_id` int(11) DEFAULT NULL,
  `u_nick` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='评论详情表';

#
# Data for table "comment_info"
#

INSERT INTO `comment_info` VALUES (1,'这是我第一条微博评论！！！！！！！1\r\n\t\t  \t\t','2016-04-28 15:13:38',2,'蛋花汤汤'),(2,'\t\t  \t\t\t\t请输入评论内容\r\n\t\t  \t\t','2016-04-28 15:16:46',2,'蛋花汤汤'),(3,'所属是是是是是所属是\t  \t\t','2016-04-28 15:21:23',2,'蛋花汤汤'),(4,'\t\t\t  \t\t\t\t给老婆评论一条~~~~~~~~·\r\n\t\t\t  \t\t','2016-04-28 15:49:16',8,'蛋花汤汤'),(5,'abcd啊啊啊啊啊啊啊啊啊啊啊 啊  \t\t','2016-04-28 16:28:20',11,NULL),(6,'23日3(⊙o⊙)23 \r\n\t\t\t  \t\t','2016-04-28 16:29:51',11,'蛋花汤汤'),(7,NULL,'2016-05-03 15:44:21',11,NULL),(8,NULL,'2016-05-03 15:44:21',11,NULL),(9,NULL,'2016-05-03 15:44:21',11,NULL);
