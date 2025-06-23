# Write your MySQL query statement below
select employee_id, IF(employee_id % 2 = 1 AND name NOT LIKE 'M%', salary, 0) as bonus from Employees order by employee_id ASC;