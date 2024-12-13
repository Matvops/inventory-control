CREATE TABLE `purchase` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `last_update` datetime(6) DEFAULT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
)