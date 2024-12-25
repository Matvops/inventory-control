CREATE TABLE purchase_product (
	purchase_id bigint NOT NULL,
	product_id bigint NOT NULL,
	PRIMARY KEY (product_id,purchase_id),
	CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_purchase_id FOREIGN KEY (purchase_id) REFERENCES purchase (id)
);
