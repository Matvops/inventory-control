DELIMITER //
CREATE PROCEDURE get_person_by_name(IN name VARCHAR(255), IN type VARCHAR(30))
BEGIN
	IF (UPPER(type) = 'EMPLOYEE') THEN

		SELECT *
        FROM vw_employee e
        WHERE e.name LIKE UPPER(CONCAT('%', name, '%'));

    ELSEIF (UPPER(type) = 'CLIENT') THEN

		SELECT *
        FROM vw_client c
        WHERE c.name LIKE UPPER(CONCAT('%', name, '%'));

    ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'TYPE NO EXISTS!';
    END IF;

END //
DELIMITER ;