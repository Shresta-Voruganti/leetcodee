# Write your MySQL query statement below
SELECT ROUND((SUM(CASE WHEN d1.order_date=d1.customer_pref_delivery_date THEN 1 ELSE 0 END)/COUNT(*))*100, 2) AS immediate_percentage
FROM Delivery d1
JOIN (SELECT delivery_id, customer_id, MIN(order_date) AS first_order_date, customer_pref_delivery_date FROM Delivery GROUP BY customer_id) d2
ON d1.customer_id = d2.customer_id AND d1.order_date = d2.first_order_date;