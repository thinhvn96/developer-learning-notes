CREATE TABLE cities (name text PRIMARY KEY, location text);
CREATE TABLE weather (city text, temp_lo int, temp_hi int, date date);
INSERT INTO cities VALUES ('San Francisco', '(-194,53)');
INSERT INTO weather VALUES ('San Francisco', 46, 50, '1994-11-27'),
                           ('San Francisco', 43, 57, '1994-11-29'),
                           ('Hayward',       37, 54, '1994-11-29');

\echo '--- inner join drops Hayward:'
SELECT * FROM weather JOIN cities ON city = name;
\echo '--- left outer join keeps Hayward with NULLs:'
SELECT * FROM weather LEFT OUTER JOIN cities ON weather.city = cities.name;
\echo '--- classic trap: WHERE on the right table turns it back into an inner join:'
SELECT * FROM weather LEFT OUTER JOIN cities ON weather.city = cities.name
WHERE cities.location IS NOT NULL;
