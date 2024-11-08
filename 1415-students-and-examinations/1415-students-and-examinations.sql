# Write your MySQL query statement below
SELECT st.student_id AS student_id, st.student_name AS student_name, sub.subject_name AS subject_name, COUNT(e.student_id) AS attended_exams
FROM Students st
CROSS JOIN Subjects sub
LEFT JOIN Examinations e
ON e.student_id = st.student_id AND e.subject_name = sub.subject_name
GROUP BY st.student_id, st.student_name, sub.subject_name
ORDER BY st.student_id, sub.subject_name;