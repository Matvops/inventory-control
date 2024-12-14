CREATE VIEW vw_employee
AS
SELECT *
FROM person
WHERE type = "EMPLOYEE";