# Write your MySQL query statement below
WITH ranked_salaries AS (
    SELECT 
        e.name AS employee_name,
        e.salary,
        e.departmentId,
        d.name AS department_name,
        DENSE_RANK() OVER (
            PARTITION BY e.departmentId
            ORDER BY e.salary DESC
        ) AS rank_in_department
    FROM 
        Employee e
    JOIN 
        Department d
    ON 
        e.departmentId = d.id
)
SELECT 
    department_name AS Department,
    employee_name AS Employee,
    salary AS Salary
FROM 
    ranked_salaries
WHERE 
    rank_in_department <= 3
ORDER BY 
    department_name ASC, salary DESC;
