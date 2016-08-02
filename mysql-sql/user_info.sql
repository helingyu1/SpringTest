# Host: 127.0.0.1  (Version 5.6.24)
# Date: 2016-08-02 08:44:07
# Generator: MySQL-Front 5.3  (Build 5.31)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "user_info"
#

CREATE TABLE `user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) DEFAULT NULL,
  `u_pwd` varchar(255) DEFAULT NULL,
  `u_email` varchar(255) DEFAULT NULL,
  `u_phone` varchar(255) DEFAULT NULL,
  `u_age` int(11) DEFAULT NULL,
  `u_sex` varchar(255) DEFAULT NULL,
  `u_nick` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `u_nick` (`u_nick`),
  UNIQUE KEY `u_name` (`u_name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

#
# Data for table "user_info"
#

INSERT INTO `user_info` VALUES (1,'helingyu','helingyu','111','111',111,'111','蛋花汤汤'),(2,'xiayuqing','xiayuqing','hhh@qq.com','18210324754',20,'male','蛋宝宝'),(8,'何凌宇','111','111','111',111,'111','假的'),(9,'user1','111','hhh','183',21,'男','沉鱼落雁'),(10,'user2','111','hh','182',111,'女','闭月羞花'),(11,'user3','111','bb','11',55,'女','倾国倾城'),(12,'user4','111','jj','12',23,'男','秀色可餐'),(13,'hhh','helingyu','1','1',1,'nan',NULL),(14,'abcd','123','11','11',11,'男','大大'),(15,'helingyu1','helingyu','default@qq.com','18210324754',25,'男','angular'),(17,'helingyu2','helingyu','default@qq.com','18210324754',25,'男','angular1'),(18,'helingyu3','helingyu','default@qq.com','18210324754',25,'男','angular2'),(19,'helingyu4','helingyu','default@qq.com','18210324754',25,'男','angular3'),(20,'helingyu5','helingyu','default@qq.com','18210324754',25,'男','angular4'),(21,'helingyu1122@qq.com','helingyu','default@qq.com','18210324754',25,'男','克鲁伊夫'),(22,'helingyu7788','helingyu1','default@qq.com','18210324754',25,'男','何凌宇7788');
