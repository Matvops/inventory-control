CREATE TABLE `person` (
  `type` varchar(31) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `created` datetime(6) DEFAULT NULL,
  `last_update` datetime(6) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cpf`)
)