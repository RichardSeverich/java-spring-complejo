-- CREATE DATA BASES
CREATE DATABASE dbcomplejo;

-- DELETE DATA BASES
DROP DATABASE dbcomplejo;

-- SELECT ALL DATA: show all rows.
SELECT * FROM users;
SELECT * FROM resources;
SELECT * FROM hours_intervals;
SELECT * FROM bookings;

-- DELETE ALL DATA: delete all rows
TRUNCATE TABLE users;
TRUNCATE TABLE resources;

-- DELETE TABLE: detele the table.
DROP TABLE users;
DROP TABLE resources;
DROP TABLE hours_intervals;
DROP TABLE bookings;

-- DELETE SPECIFIC ROW.
DELETE FROM users WHERE id = 1000;
DELETE FROM resources WHERE id = 1000;

-- ALL AVALIABLES HOURS 
SELECT hours_intervals.*
FROM hours_intervals
WHERE hours_intervals.id
NOT IN (
  SELECT bookings.id_hours_interval 
  FROM bookings 
  WHERE bookings.id_resource = 1001 
  AND bookings.booking_date = "2021-01-03"
);

-- ALL RESERVED HOURS
SELECT
bookings.id,
resources.id AS `id_resource`,
hours_intervals.id AS `id_hours_interval`,
resources.name AS `resource_name`,
hours_intervals.name AS `hours_interval_name`,
bookings.booking_date,
bookings.creation_date,
bookings.update_date,
bookings.created_by,
bookings.updated_by 
FROM hours_intervals 
INNER JOIN bookings 
ON hours_intervals.id=bookings.id_hours_interval 
INNER JOIN resources 
ON resources.id=bookings.id_resource 
WHERE bookings.id_resource = 1008 
AND bookings.booking_date = "2021-01-03";

-- INNER JOIN GENERIC
SELECT nombreColumna(s)
FROM tabla1
INNER JOIN tabla2
ON tabla1.nombreColumna = table2.nombreColumna;
