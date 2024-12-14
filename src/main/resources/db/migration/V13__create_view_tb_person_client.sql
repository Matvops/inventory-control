CREATE VIEW vw_client
AS
SELECT *
FROM person
WHERE type = "CLIENT";