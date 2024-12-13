DELIMITER ;;
CREATE PROCEDURE `get_product_by_filter_category`(IN category VARCHAR(30), IN material VARCHAR(30))
BEGIN
	SELECT *
    FROM product p
    WHERE p.category = UPPER(category) AND p.material = UPPER(material);
END ;;
DELIMITER ;