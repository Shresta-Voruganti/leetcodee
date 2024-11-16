# Write your MySQL query statement below
SELECT s.product_id, s.year AS first_year, s.quantity, s.price
FROM Sales s
JOIN (SELECT product_id, MIN(year) AS firstyear 
      FROM Sales 
      GROUP BY product_id) p2
ON s.product_id = p2.product_id AND s.year = p2.firstyear;