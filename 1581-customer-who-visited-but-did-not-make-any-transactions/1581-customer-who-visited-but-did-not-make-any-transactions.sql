-- Write your PostgreSQL query statement below
-- Visit and no transaction

SELECT v.customer_id, count(v.visit_id) as count_no_trans
FROM Visits v
LEFT JOIN Transactions t
ON t.visit_id= v.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;
