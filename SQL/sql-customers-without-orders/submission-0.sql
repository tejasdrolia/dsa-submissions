-- Write your query below
select name from customers where name not in
(select c.name from customers c inner join orders o on c.id = o.customer_id );