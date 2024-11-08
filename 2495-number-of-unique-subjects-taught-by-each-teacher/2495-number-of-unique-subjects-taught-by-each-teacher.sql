# Write your MySQL query statement below
SELECT t.teacher_id AS teacher_id, COUNT(DISTINCT t.subject_id) AS cnt
FROM Teacher t
GROUP BY t.teacher_id;