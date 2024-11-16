# Write your MySQL query statement below
SELECT 
    p1.product_id, 
    COALESCE(
        (SELECT new_price 
         FROM Products 
         WHERE product_id = p1.product_id AND change_date <= '2019-08-16'
         ORDER BY change_date DESC 
         LIMIT 1), 
        10
    ) AS price
FROM 
    (SELECT DISTINCT product_id FROM Products) p1;
