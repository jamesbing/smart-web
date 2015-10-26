 CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

 CREATE TABLE `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `realname` varchar(50) NOT NULL,
  `identity_card` varchar(30) NOT NULL,
  `company` varchar(30) NOT NULL,
  `phone` int(11) DEFAULT NULL,
  `wechat` varchar(20) NOT NULL,
  `create_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `image` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
 )

 insert into service (realname,identity_card,company,phone,wechat,create_time,update_time,image)values('zzx4','006','miyuan',18612624951,'123',now(),now(),'images/w6.jpg');