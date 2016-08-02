# Host: 127.0.0.1  (Version 5.6.24)
# Date: 2016-08-02 08:42:05
# Generator: MySQL-Front 5.3  (Build 5.31)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "blog_info"
#

CREATE TABLE `blog_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `isTurn` int(11) DEFAULT NULL,
  `time` varchar(25) NOT NULL DEFAULT '20160727132816',
  `turn` int(10) DEFAULT '0' COMMENT '转发次数',
  `keep` int(10) DEFAULT '0' COMMENT '收藏次数',
  `comment` int(10) DEFAULT '0' COMMENT '评论次数',
  `Uname` varchar(20) DEFAULT NULL COMMENT '所属用户id',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Data for table "blog_info"
#

INSERT INTO `blog_info` VALUES (2,'这真不是我的第一条微博了。。',NULL,'20160727132816',0,0,0,'helingyu'),(3,'这是第二条微博了',NULL,'20160727132816',0,0,0,'helingyu'),(4,'输入微博内容\r\n\t\t',NULL,'20160727132816',0,0,0,'helingyu'),(5,'准备开始疯狂的发微博了！\t\t',NULL,'20160727132816',0,0,0,'xiayuqing'),(6,'天气热了，好容易烦躁！！！\r\n\t\t',NULL,'20160727132816',0,0,0,'xiayuqing'),(7,'开始发微博了！！！\r\n\t\t',NULL,'20160727132816',0,0,0,'xiayuqing'),(8,'又发了一条！',NULL,'20160727132816',0,0,0,'xiayuqing'),(9,'微博内容都好没有营养。。。\r\n\t\t',NULL,'20160727132816',0,0,0,'xiayuqing'),(10,'昨天鲁能又输了\r\n\t\t',NULL,'20160727132816',0,0,0,'xiayuqing'),(11,'这是一条测试微博~~~~~！',NULL,'20160727132816',0,0,0,'helingyu'),(12,'10010101010省考\t\t',NULL,'20160727132816',0,0,0,'helingyu'),(13,NULL,NULL,'20160727132816',0,0,0,NULL),(14,'啊哈哈哈哈0727发成功了没有？',NULL,'20160727151305',0,0,0,'helingyu'),(15,'0727再尝试发一条哦~~~~~~~~~~~~~',NULL,'20160727151643',0,0,0,'helingyu'),(16,'0727我试试哈~~~~~',NULL,'20160727151707',0,0,0,'helingyu'),(17,'我试试发一条微博',NULL,'20160727151902',0,0,0,'何凌宇7788'),(18,'我再发一条微博吧~~~',NULL,'20160729164619',0,0,0,'helingyu');
