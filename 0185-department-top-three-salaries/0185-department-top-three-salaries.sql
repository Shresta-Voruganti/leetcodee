# Write your MySQL query statement below
WITH ranked_employees AS (
    SELECT e.id, e.name, e.salary, e.departmentId,
           DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rank_e
    FROM Employee e
)
SELECT d.name AS Department, r.name AS Employee, r.salary AS Salary
FROM ranked_employees r
JOIN Department d ON r.departmentId = d.id
WHERE r.rank_e <= 3
ORDER BY d.name ASC, r.salary DESC;


