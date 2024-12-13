DELIMITER ;;
CREATE PROCEDURE `get_product_with_a_filter`(IN field_filter VARCHAR(30), IN filter_value VARCHAR(30))
BEGIN
	IF field_filter = 'NAME' THEN
        SELECT *
        FROM product
        WHERE name LIKE UPPER(CONCAT('%', filter_value, '%'));
	ELSEIF field_filter = 'CATEGORY' THEN
        SELECT *
        FROM product
        WHERE category = UPPER(filter_value);
	ELSEIF field_filter = 'MATERIAL' THEN
		SELECT *
        FROM product
        WHERE material = UPPER(filter_value);
	ELSEIF field_filter = 'BRAND' THEN
        SELECT *
        FROM product
        WHERE brand = UPPER(filter_value);
	ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid field filter';
	END IF;
END ;;
DELIMITER ;