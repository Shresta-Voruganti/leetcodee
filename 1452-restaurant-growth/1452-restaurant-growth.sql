# Write your MySQL query statement below
SELECT
    visited_on,
    (
        SELECT SUM(amount)
        FROM customer
        WHERE visited_on BETWEEN DATE_SUB(c.visited_on, INTERVAL 6 DAY) AND c.visited_on
    ) AS amount,
    ROUND(
        (
            SELECT SUM(amount) / 7
            FROM customer
            WHERE visited_on BETWEEN DATE_SUB(c.visited_on, INTERVAL 6 DAY) AND c.visited_on
        ),
        2
    ) AS average_amount
FROM customer c
WHERE visited_on >= (
        SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY)
        FROM customer
    )
GROUP BY visited_on;
-- SELECT 
--     c1.visited_on,
--     SUM(c2.amount) AS amount,
--     ROUND(COALESCE(SUM(c2.amount), 0) / 7.0, 2)
--  AS average_amount
-- FROM 
--     Customer c1
-- JOIN 
--     Customer c2
--     ON c2.visited_on BETWEEN DATE_SUB(c1.visited_on, INTERVAL 6 DAY) AND c1.visited_on
-- GROUP BY 
--     c1.visited_on
-- HAVING 
--     COUNT(DISTINCT c2.visited_on) = 7
-- ORDER BY 
--     c1.visited_on;


