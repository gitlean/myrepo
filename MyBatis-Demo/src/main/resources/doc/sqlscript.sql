--����ӰƬ��  
CREATE TABLE `film` (  
      `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,  
      `fname` varchar(50) NOT NULL,  
      PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;  
      
INSERT INTO `film` VALUES ('1', '����Ц');  
INSERT INTO `film` VALUES ('2', '���ձȺ���4');  
INSERT INTO `film` VALUES ('3', '�ھ�ӥ��');  
INSERT INTO `film` VALUES ('4', '�ٶ��뼤��5');  
INSERT INTO `film` VALUES ('5', '����');  
INSERT INTO `film` VALUES ('6', '�');  
INSERT INTO `film` VALUES ('7', '����Ӣ��֮�����Ӵ�˵');  
INSERT INTO `film` VALUES ('8', 'Σ������');  

truncate table film;

select * from film;