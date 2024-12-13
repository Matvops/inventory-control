CREATE TABLE `sale_product` (
  `price` float NOT NULL,
  `quantity` int DEFAULT NULL,
  `product_id` bigint NOT NULL,
  `sale_id` bigint NOT NULL,
  PRIMARY KEY (`product_id`,`sale_id`),
  KEY `sale_product_fk_sale_id` (`sale_id`),
  CONSTRAINT `sale_product_fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `sale_product_fk_sale_id` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`id`)
)