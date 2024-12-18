# Write your MySQL query statement below
SELECT id, COUNT(id) AS num
FROM (
    SELECT requester_id AS id
    FROM RequestAccepted
    WHERE requester_id IS NOT NULL

    UNION ALL

    SELECT accepter_id AS id
    FROM RequestAccepted
    WHERE accepter_id IS NOT NULL 
) AS all_ids
GROUP BY id
ORDER BY num DESC
LIMIT 1;