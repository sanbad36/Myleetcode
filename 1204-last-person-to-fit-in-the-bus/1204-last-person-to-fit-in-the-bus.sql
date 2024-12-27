# Write your MySQL query statement below

select  person_name
FROM (
select turn , weight , person_name ,
sum(weight) over(order by turn asc) as weightSummation
from Queue 
)t 
WHERE weightSummation <= 1000
ORDER BY turn DESC
limit 1