DELIMITER //
CREATE PROCEDURE get_person_by_cpf(IN cpf CHAR(11), IN type VARCHAR(30))
BEGIN
	if(UPPER(type) = 'EMPLOYEE') THEN

		SELECT *
        FROM vw_employee e
        WHERE e.cpf = cpf;

    ELSEIF(UPPER(type) = 'CLIENT') THEN

        SELECT *
        FROM vw_client c
        WHERE c.cpf = cpf;

    ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT= 'ERROR IN PROCEDURE GET_PERSON_BY_CPFF';
    END IF;
END //
DELIMITER ;