# Write your MySQL query statement below
SELECT e.reports_to AS employee_id, r.name AS name, COUNT(e.employee_id) AS reports_count, ROUND(AVG(e.age)) AS average_age
FROM Employees e
JOIN Employees r
ON e.reports_to = r.employee_id
GROUP BY e.reports_to
ORDER BY e.reports_to ASC;