# Write your MySQL query statement below
SELECT q.query_name, 
    ROUND((SUM(q.rating / q.position))/COUNT(q.query_name), 2) AS quality, 
    ROUND((SUM(CASE WHEN q.rating < 3 THEN 1 ELSE 0 END)/COUNT(q.query_name)) * 100, 2) AS poor_query_percentage
FROM Queries q
WHERE q.query_name IS NOT NULL
GROUP BY q.query_name;
