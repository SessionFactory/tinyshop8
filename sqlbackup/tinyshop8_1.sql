/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17 : Database - tinyshop8
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = '' */;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`tinyshop8` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tinyshop8`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` BIGINT(20) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `hibernate_sequence` */

INSERT INTO `hibernate_sequence` (`next_val`) VALUES (20), (20), (20), (20);

/*Table structure for table `jpa_goods` */

DROP TABLE IF EXISTS `jpa_goods`;

CREATE TABLE `jpa_goods` (
  `goods_id`            BIGINT(20) NOT NULL,
  `addDate`             VARCHAR(255) DEFAULT NULL,
  `cost_price`          DOUBLE       DEFAULT NULL,
  `keyword`             VARCHAR(300) DEFAULT NULL,
  `market_price`        DOUBLE       DEFAULT NULL,
  `goodsname`           VARCHAR(400) DEFAULT NULL,
  `goods_no`            VARCHAR(300) DEFAULT NULL,
  `pro_no`              VARCHAR(50)  DEFAULT NULL,
  `sell_price`          DOUBLE       DEFAULT NULL,
  `store_nums`          INT(11)      DEFAULT NULL,
  `subtitle`            VARCHAR(800) DEFAULT NULL,
  `weight`              VARCHAR(10)  DEFAULT NULL,
  `goods_brand_m2o`     BIGINT(20)   DEFAULT NULL,
  `goods_type_m2o`      BIGINT(20)   DEFAULT NULL,
  `join_m2o_goods_user` BIGINT(20)   DEFAULT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `fk_goods_brand_m2o` (`goods_brand_m2o`),
  KEY `fk_goods_type_m2o` (`goods_type_m2o`),
  KEY `fk_join_m2o_goods_user` (`join_m2o_goods_user`),
  CONSTRAINT `fk_goods_brand_m2o` FOREIGN KEY (`goods_brand_m2o`) REFERENCES `jpa_goodsbrand` (`brand_id`),
  CONSTRAINT `fk_goods_type_m2o` FOREIGN KEY (`goods_type_m2o`) REFERENCES `jpa_goodstype` (`type_id`),
  CONSTRAINT `fk_join_m2o_goods_user` FOREIGN KEY (`join_m2o_goods_user`) REFERENCES `jpa_user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `jpa_goods` */

INSERT INTO `jpa_goods` (`goods_id`, `addDate`, `cost_price`, `keyword`, `market_price`, `goodsname`, `goods_no`, `pro_no`, `sell_price`, `store_nums`, `subtitle`, `weight`, `goods_brand_m2o`, `goods_type_m2o`, `join_m2o_goods_user`)
VALUES (3, 'Fri Sep 01 20:38:44 CST 2017', 4000, '华为', 4500, '荣耀 NOTE 8 4GB+64GB 通4G手机 冰河银 冰河银 4G 128GB', '1989377885', '1989377885', 3499, 1000, '华为手机', '2公斤', NULL, NULL, 1), (7, '2017-09-06 16:02:25', 70000, NULL, 71000, '华硕（ASUS）玩家国度GX800VH7820 18.4英寸ROG双独显水冷游戏笔记本电脑 I7-7820HK 64G内存 1.5TB固态', '11298064083', '11298064083', 69999, 10, 'huashuoComputer', '2.5KG', NULL, 6, 1),
  (8, '2017-09-06 16:02:25', 40999, NULL, 40999, '微星 MSI GT83VR 7RF-203CN 18.4英寸游戏笔记本电脑 （i7-7920HQ 32G 512G+1T 双GTX1080 WIN10 机械键盘）黑', '1989750687', '1989750687', 40999, 10, 'weixingComputer', '2.5KG', NULL, 6, 1), (9, '2017-09-06 16:02:25', 18999, NULL, 18999, '外星人Alienware17C-R2738 17.3英寸游戏笔记本电脑(i7-7700HQ 16G 256GSSD+1T GTX1060 6G独显 FHD Win10)', '4335716', '4335716', 18999, 10, 'waixingrenComputer', '2.5KG', NULL, 6, 1),
  (13, '2017-08-12 19:44:30', 234, '234', 24234, 'abc', '24', '234', 34, 4, '234', '234', NULL, 12, 1), (16, '2017-08-12 19:50:02', 6999, '6999', 6999, '我的电脑', '6999', '6999', 6999, 6999, '6999', '6999', NULL, 6, 1), (17, '2017-08-12 19:50:02', 6999, '6999', 6999, '我的电脑', '6999', '6999', 6999, 6999, '6999', '6999', NULL, 6, 1), (18, '2017-08-12 19:50:02', 6999, '6999', 6999, '我的电脑', '6999', '6999', 6999, 6999, '6999', '6999', NULL, 6, 1),
  (19, '2017-08-12 19:50:02', 6999, '6999', 6999, '我的电脑3333', '6999', '6999', 6999, 6999, '6999', '6999', NULL, 6, 1);

/*Table structure for table `jpa_goods_brand_set` */

DROP TABLE IF EXISTS `jpa_goods_brand_set`;

CREATE TABLE `jpa_goods_brand_set` (
  `GoodsBrand8JPA_brand_id` BIGINT(20) NOT NULL,
  `goods8JPASet_goods_id`   BIGINT(20) NOT NULL,
  PRIMARY KEY (`GoodsBrand8JPA_brand_id`, `goods8JPASet_goods_id`),
  UNIQUE KEY `UK_eskpo2dsuitxlx19fyh9y34i5` (`goods8JPASet_goods_id`),
  CONSTRAINT `FKl0x2wuhvv1yyoa8iex20libs9` FOREIGN KEY (`goods8JPASet_goods_id`) REFERENCES `jpa_goods` (`goods_id`),
  CONSTRAINT `fk_jpa_goods_brand_set` FOREIGN KEY (`GoodsBrand8JPA_brand_id`) REFERENCES `jpa_goodsbrand` (`brand_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `jpa_goods_brand_set` */

/*Table structure for table `jpa_goods_children_set` */

DROP TABLE IF EXISTS `jpa_goods_children_set`;

CREATE TABLE `jpa_goods_children_set` (
  `GoodsType8JPA_type_id` BIGINT(20) NOT NULL,
  `childrenSet_type_id`   BIGINT(20) NOT NULL,
  PRIMARY KEY (`GoodsType8JPA_type_id`, `childrenSet_type_id`),
  UNIQUE KEY `UK_681iilyout6vgmh833g0cynd4` (`childrenSet_type_id`),
  CONSTRAINT `FK3h4hs0cnyjty8r4usxa94l1h0` FOREIGN KEY (`childrenSet_type_id`) REFERENCES `jpa_goodstype` (`type_id`),
  CONSTRAINT `fk_jpa_goods_children_set` FOREIGN KEY (`GoodsType8JPA_type_id`) REFERENCES `jpa_goodstype` (`type_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `jpa_goods_children_set` */

INSERT INTO `jpa_goods_children_set` (`GoodsType8JPA_type_id`, `childrenSet_type_id`) VALUES (10, 11), (10, 12);

/*Table structure for table `jpa_goods_img_list` */

DROP TABLE IF EXISTS `jpa_goods_img_list`;

CREATE TABLE `jpa_goods_img_list` (
  `Goods8JPA_goods_id` BIGINT(20) NOT NULL,
  `goods_img_list`     VARCHAR(255) DEFAULT NULL,
  KEY `fk_goods_img` (`Goods8JPA_goods_id`),
  CONSTRAINT `fk_goods_img` FOREIGN KEY (`Goods8JPA_goods_id`) REFERENCES `jpa_goods` (`goods_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `jpa_goods_img_list` */

INSERT INTO `jpa_goods_img_list` (`Goods8JPA_goods_id`, `goods_img_list`)
VALUES (13, '234'), (13, ''), (13, '4'), (13, ''), (13, '24'), (13, ''), (13, '24'), (13, ''), (13, '24'), (16, '6999'), (16, ''), (16, '6999'), (16, ''), (16, '6999'), (16, ''), (16, '6999'), (16, ''), (16, '6999'), (17, '6999'), (17, ''), (17, '6999'), (17, ''), (17, '6999'), (17, ''), (17, '6999'), (17, ''), (17, '6999'), (18, '6999'), (18, ''), (18, '6999'), (18, ''), (18, '6999'), (18, ''), (18, '6999'), (18, ''), (18, '6999'), (19, '6999'), (19, ''), (19, '6999'), (19, ''), (19, '6999'),
  (19, ''), (19, '6999'), (19, ''), (19, '6999');

/*Table structure for table `jpa_goods_type_set` */

DROP TABLE IF EXISTS `jpa_goods_type_set`;

CREATE TABLE `jpa_goods_type_set` (
  `GoodsType8JPA_type_id` BIGINT(20) NOT NULL,
  `goods8JPASet_goods_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`GoodsType8JPA_type_id`, `goods8JPASet_goods_id`),
  UNIQUE KEY `UK_bxkq96h79rcr61h9su3qyvx6w` (`goods8JPASet_goods_id`),
  CONSTRAINT `FKtko52f73s2baqqpclihunihuc` FOREIGN KEY (`goods8JPASet_goods_id`) REFERENCES `jpa_goods` (`goods_id`),
  CONSTRAINT `fk_jpa_goods_type_set` FOREIGN KEY (`GoodsType8JPA_type_id`) REFERENCES `jpa_goodstype` (`type_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `jpa_goods_type_set` */

INSERT INTO `jpa_goods_type_set` (`GoodsType8JPA_type_id`, `goods8JPASet_goods_id`) VALUES (6, 7), (6, 8), (6, 9), (12, 13);

/*Table structure for table `jpa_goodsbrand` */

DROP TABLE IF EXISTS `jpa_goodsbrand`;

CREATE TABLE `jpa_goodsbrand` (
  `brand_id`   BIGINT(20) NOT NULL,
  `brand_name` VARCHAR(300) DEFAULT NULL,
  `brand_sort` INT(11)      DEFAULT NULL,
  `brand_url`  VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `jpa_goodsbrand` */

/*Table structure for table `jpa_goodstype` */

DROP TABLE IF EXISTS `jpa_goodstype`;

CREATE TABLE `jpa_goodstype` (
  `type_id`    BIGINT(20) NOT NULL,
  `type_alias` VARCHAR(500) DEFAULT NULL,
  `type_name`  VARCHAR(200) DEFAULT NULL,
  `type_sort`  INT(11)      DEFAULT NULL,
  `parent_id`  BIGINT(20)   DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  KEY `fk_parent` (`parent_id`),
  CONSTRAINT `fk_parent` FOREIGN KEY (`parent_id`) REFERENCES `jpa_goodstype` (`type_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `jpa_goodstype` */

INSERT INTO `jpa_goodstype` (`type_id`, `type_alias`, `type_name`, `type_sort`, `parent_id`) VALUES (6, 'computer', '电脑', 0, NULL), (10, 'mobile', '手机', 0, NULL), (11, 'mobileConfig', '手机配件', 1, 10), (12, 'mobileYL', '娱乐', 2, 10);

/*Table structure for table `jpa_user` */

DROP TABLE IF EXISTS `jpa_user`;

CREATE TABLE `jpa_user` (
  `id`       BIGINT(20) NOT NULL,
  `password` VARCHAR(20) DEFAULT NULL,
  `username` VARCHAR(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7vaiuu0nyrnryow6o08dk6o6t` (`username`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `jpa_user` */

INSERT INTO `jpa_user` (`id`, `password`, `username`) VALUES (1, 'administrator', 'administrator'), (2, 'root', 'root'), (4, 'tinyshop', 'tinyshop'), (5, 'abc', 'abc');

/*Table structure for table `jpa_user_goodsset_table` */

DROP TABLE IF EXISTS `jpa_user_goodsset_table`;

CREATE TABLE `jpa_user_goodsset_table` (
  `User8JPA_id`           BIGINT(20) NOT NULL,
  `goods8JPASet_goods_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`User8JPA_id`, `goods8JPASet_goods_id`),
  UNIQUE KEY `UK_54ntn2gpod75o6mm1adctwq6` (`goods8JPASet_goods_id`),
  CONSTRAINT `FKa9i683kp4ogw7ppmio7poiufi` FOREIGN KEY (`goods8JPASet_goods_id`) REFERENCES `jpa_goods` (`goods_id`),
  CONSTRAINT `table_user_goodsSet` FOREIGN KEY (`User8JPA_id`) REFERENCES `jpa_user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `jpa_user_goodsset_table` */

INSERT INTO `jpa_user_goodsset_table` (`User8JPA_id`, `goods8JPASet_goods_id`) VALUES (1, 3), (1, 7), (1, 8), (1, 9);

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
