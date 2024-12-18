# Write your MySQL query statement below
-- SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
-- FROM Employee e
-- JOIN Department d
-- ON e.departmentId = d.id
-- WHERE e.salary IN (SELECT DISTINCT e1.salary 
--     FROM Employee e1 
--     WHERE e1.departmentId = e.departmentId 
--     ORDER BY e1.salary DESC 
--     LIMIT 3)
WITH ranked_employees AS (
    SELECT e.id, e.name, e.salary, e.departmentId,
           DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rank_e
    FROM Employee e
)
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM ranked_employees e
JOIN Department d ON e.departmentId = d.id
WHERE e.rank_e <= 3
ORDER BY d.name ASC, e.salary DESC;


-- WITH max_salaries AS (
--     SELECT DISTINCT e1.salary AS salary
--     FROM Employee e1
--     WHERE e1.departmentId = e.departmentId
--     ORDER BY e1.salary DESC
--     LIMIT 3
-- )
-- SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
-- FROM Employee e
-- JOIN Department d
-- ON e.departmentId = d.id
-- WHERE e.salary IN (SELECT salary FROM max_salaries);
