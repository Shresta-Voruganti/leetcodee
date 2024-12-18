# Write your MySQL query statement below
WITH max_salaries AS (
    SELECT e.id, e.name, e.salary, e.departmentId, DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rank_e
    FROM Employee e
)
SELECT d.name AS Department, r.name AS Employee, r.salary AS Salary
FROM max_salaries r
JOIN Department d
ON r.departmentId = d.id
WHERE r.rank_e <= 3
ORDER BY d.name ASC, r.salary DESC;