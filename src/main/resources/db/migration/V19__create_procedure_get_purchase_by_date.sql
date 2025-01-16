DELIMITER //
CREATE PROCEDURE get_purchase_by_date(IN date VARCHAR(10))
BEGIN
	SELECT *
    FROM purchase
    WHERE created LIKE CONCAT(date, '%');
END //
DELIMITER ;