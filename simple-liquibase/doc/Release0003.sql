--liquibase formatted sql
--changeset gpl:Release0003-1
CREATE TABLE table3 (
  id int(11) NOT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM;
ALTER TABLE  table3 CHANGE  id  id INT( 11 ) AUTO_INCREMENT;
ALTER TABLE  table3 CHANGE  name  firstname VARCHAR( 255 );
INSERT INTO  table3 (id, firstname) VALUES (NULL, 'name1'),(NULL, 'name2'), (NULL, 'name3');
--rollback drop table table3;