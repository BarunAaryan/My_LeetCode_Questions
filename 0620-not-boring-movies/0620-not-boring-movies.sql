-- Write your PostgreSQL query statement below
SELECT * FROM Cinema
WHERE id %2 !=0 and description != 'boring' ORDER BY RATING DESC;