# Write your MySQL query statement below
SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM Insurance i1
WHERE
(SELECT COUNT(*) FROM Insurance i2 WHERE i1.tiv_2015 = i2.tiv_2015) > 1 AND (SELECT COUNT(*) FROM Insurance i3 WHERE i1.lat = i3.lat AND i1.lon = i3.lon) = 1;