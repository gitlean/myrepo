--创建影片表  
CREATE TABLE `film` (  
      `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,  
      `fname` varchar(50) NOT NULL,  
      PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;  
      
INSERT INTO `film` VALUES ('1', '刀见笑');  
INSERT INTO `film` VALUES ('2', '加勒比海盗4');  
INSERT INTO `film` VALUES ('3', '第九鹰团');  
INSERT INTO `film` VALUES ('4', '速度与激情5');  
INSERT INTO `film` VALUES ('5', '雷神');  
INSERT INTO `film` VALUES ('6', '最爱');  
INSERT INTO `film` VALUES ('7', '宇宙英雄之超银河传说');  
INSERT INTO `film` VALUES ('8', '危情三日');  

truncate table film;

select * from film;