-- CREATE DATA BASES
CREATE DATABASE dbescuela;

-- DELETE DATA BASES
DROP DATABASE dbescuela;

-- SELECT ALL DATA: show all rows.
SELECT * FROM users;

-- DELETE ALL DATA: delete all rows
TRUNCATE TABLE users;

-- DELETE TABLE: detele the table.
DROP TABLE users;

-- DELETE SPECIFIC ROW.
DELETE FROM users WHERE id = 1000;

-- INNER JOIN GENERIC
SELECT nombreColumna(s)
FROM tabla1
INNER JOIN tabla2
ON tabla1.nombreColumna = table2.nombreColumna;
