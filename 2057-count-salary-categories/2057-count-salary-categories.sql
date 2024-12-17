# Write your MySQL query statement below
SELECT 'Low Salary' AS category, COUNT(*) AS accounts_count
FROM Accounts
WHERE income < 20000

UNION ALL

SELECT 'Average Salary' AS category, COUNT(*) AS accounts_count
FROM Accounts
WHERE income BETWEEN 20000 AND 50000

UNION ALL

SELECT 'High Salary' AS category, COUNT(*) AS accounts_count
FROM Accounts
WHERE income > 50000;


-- SELECT category, COUNT(*) AS accounts_count
-- FROM (
--     SELECT 
--         CASE 
--             WHEN income < 20000 THEN 'Low Salary'
--             WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
--             WHEN income > 50000 THEN 'High Salary'
--         END AS category
--     FROM Accounts
-- ) AS categorized_accounts
-- GROUP BY category; 