DROP TABLE  IF EXISTS user_state;
CREATE TABLE `user_state` (
  `user_id` BIGINT NOT NULL,
  `login` BIT(1) DEFAULT NULL,
  `register` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);  
 
DROP TABLE  IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` BIGINT NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ;

DROP TABLE  IF EXISTS application;
CREATE TABLE `application` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) DEFAULT NULL,
  `name` VARCHAR(255) NOT NULL,
  `url_addr` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ;

DROP TABLE  IF EXISTS `user_auth`;
CREATE TABLE `user_auth` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `app_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`)
) ;

insert into user(user_id,email) values(1, "ywhking@gmail.com");
insert into user(user_id,email) values(2, "ywhking@outlook.com");


insert into  application(name,description,url_addr) values("Baidu", "office automation","http://www.baidu.com");
insert into  application(name,description,url_addr) values("OA", "office automation","http://oa.kuduoduo.net");
insert into  application(name,description,url_addr) values("CRM", "customer relation mananger system","http://crm.kuduoduo.net");
insert into  application(name,description,url_addr) values("Rocket.chat", "Instant messaging  system","http://rocketchat.kuduoduo.net");
insert into  application(name,description,url_addr) values("Jitsi", "Vedio conference  system","http://jitsi.kuduoduo.net");

insert into user_auth(user_id, app_id) values(1,1);
insert into user_auth(user_id, app_id) values(1,2);
insert into user_auth(user_id, app_id) values(1,3);
insert into user_auth(user_id, app_id) values(1,4);
insert into user_auth(user_id, app_id) values(1,5);

insert into user_auth(user_id, app_id) values(2,3);
insert into user_auth(user_id, app_id) values(2,4);
insert into user_auth(user_id, app_id) values(2,5);

