# Write your MySQL query statement below
SELECT t.id 
FROM Weather AS t
JOIN Weather AS y
ON t.recordDate = DATE_ADD(y.recordDate, INTERVAL 1 DAY)
WHERE t.temperature > y.temperature;