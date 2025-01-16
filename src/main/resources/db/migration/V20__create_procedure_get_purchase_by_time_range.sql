DELIMITER //
CREATE PROCEDURE get_purchase_by_time_range(first VARCHAR(11), last VARCHAR(11))
BEGIN
    SELECT *
    FROM purchase
    WHERE DATE(created)
    BETWEEN first
    AND last;
END //
DELIMITER ;