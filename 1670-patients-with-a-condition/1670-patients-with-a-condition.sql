# Write your MySQL query statement below
SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions REGEXP '(^|[^A-Za-z0-9+])DIAB1[0-9]*';