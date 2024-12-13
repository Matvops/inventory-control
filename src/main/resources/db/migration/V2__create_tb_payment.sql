CREATE TABLE `payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `number_installment` int DEFAULT NULL,
  `payment` enum('CREDIT_CARD','DEBIT_CARD','MONEY','ON_THE_CUFF','PIX') DEFAULT NULL,
  PRIMARY KEY (`id`)
)