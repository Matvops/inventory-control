CREATE TABLE `sale` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `date` datetime(6) NOT NULL,
  `last_update` datetime(6) DEFAULT NULL,
  `observations` varchar(255) NOT NULL,
  `paid` bit(1) DEFAULT NULL,
  `price` float NOT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `payment_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sale_fk_client_id` (`client_id`),
  KEY `sale_fk_employee_id` (`employee_id`),
  KEY `sale_fk_payment_id` (`payment_id`),
  CONSTRAINT `sale_fk_payment_id` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`),
  CONSTRAINT `sale_fk_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `person` (`cpf`),
  CONSTRAINT `sale_fk_client_id` FOREIGN KEY (`client_id`) REFERENCES `person` (`cpf`)
)