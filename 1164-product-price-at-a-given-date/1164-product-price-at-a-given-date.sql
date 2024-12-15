# Write your MySQL query statement below
with last as(
  select p.product_id,p.change_date,p.new_price 
  from Products as p
 
   where p.change_date=(select max(change_date) from Products  where p.product_id=product_id
     and change_date <= '2019-08-16')
 
)
select distinct p.product_id,if (t.new_price is null,10,t.new_price) as price 
from Products as p left join last as t on p.product_id=t.product_id;
