# Write your MySQL query statement below
SELECT user_id, name, mail
FROM Users
WHERE mail LIKE '%@leetcode.com' AND mail REGEXP '^[A-Za-z][A-Za-z0-9_.-]*(@leetcode\\.com)$';