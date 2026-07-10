-- Write your query below
SELECT name from sales_person where sales_id NOT IN 
(select sales_id from orders where com_id =1);