DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE `userlogin`  (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `password` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `cellphone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,


                         PRIMARY KEY (`id`)
)


ENGINE = ARCHIVE CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compressed;

insert into `userlogin` (`username`, `password`,`cellphone`,`email`,`type`) values('test','123456','111110000','111111@gmail.com','1');

SET FOREIGN_KEY_CHECKS = 1;