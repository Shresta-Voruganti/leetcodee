# Write your MySQL query statement below
SELECT r.contest_id AS contest_id, ROUND(((COUNT(r.user_id))/(SELECT COUNT(u.user_id) FROM Users u)) * 100, 2) AS percentage
FROM Register r
GROUP BY r.contest_id
ORDER BY percentage DESC, r.contest_id ASC;