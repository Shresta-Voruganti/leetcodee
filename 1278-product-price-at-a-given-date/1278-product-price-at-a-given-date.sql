# Write your MySQL query statement below
SELECT p1.product_id AS product_id, 
    COALESCE((SELECT new_price 
              FROM Products 
              WHERE p1.product_id = product_id AND change_date <= '2019-08-16'  
              ORDER BY change_date DESC 
              LIMIT 1), 10) 
              AS price
FROM (SELECT DISTINCT product_id FROM Products) p1; 