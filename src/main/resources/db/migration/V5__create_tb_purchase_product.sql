CREATE TABLE `purchase_product` (
  `price` float NOT NULL,
  `quantity` int NOT NULL,
  `purchase_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`product_id`,`purchase_id`),
  KEY `purchase_product_fk_purchase_id` (`purchase_id`),
  CONSTRAINT `purchase_product_fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `purchase_product_fk_purchase_id` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`)
)