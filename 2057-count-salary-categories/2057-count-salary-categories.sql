# Write your MySQL query statement below
SELECT category, 
       COUNT(a.account_id) AS accounts_count
FROM (
    SELECT 'Low Salary' AS category
    UNION ALL
    SELECT 'Average Salary'
    UNION ALL
    SELECT 'High Salary'
) AS categories
LEFT JOIN Accounts a
    ON ( (categories.category = 'Low Salary' AND a.income < 20000)
       OR (categories.category = 'Average Salary' AND a.income BETWEEN 20000 AND 50000)
       OR (categories.category = 'High Salary' AND a.income > 50000) )
GROUP BY category;



-- SELECT 'Low Salary' AS category, COUNT(*) AS accounts_count
-- FROM Accounts
-- WHERE income < 20000

-- UNION ALL

-- SELECT 'Average Salary' AS category, COUNT(*) AS accounts_count
-- FROM Accounts
-- WHERE income BETWEEN 20000 AND 50000

-- UNION ALL

-- SELECT 'High Salary' AS category, COUNT(*) AS accounts_count
-- FROM Accounts
-- WHERE income > 50000;


-- don't use this approach
-- SELECT category,
--        COUNT(account_id) AS accounts_count
-- FROM (
--     SELECT 
--         CASE 
--             WHEN income < 20000 THEN 'Low Salary'
--             WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
--             WHEN income > 50000 THEN 'High Salary'
--         END AS category,
--         account_id
--     FROM Accounts
-- ) AS categorized_accounts
-- GROUP BY category
-- ORDER BY FIELD(category, 'Low Salary', 'Average Salary', 'High Salary');

