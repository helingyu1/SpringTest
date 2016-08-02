# Host: 127.0.0.1  (Version 5.6.24)
# Date: 2016-08-02 08:43:58
# Generator: MySQL-Front 5.3  (Build 5.31)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "mention_info"
#

CREATE TABLE `mention_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `isMentionedID` varchar(255) NOT NULL DEFAULT '',
  `commentID` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='@±í';

#
# Data for table "mention_info"
#

