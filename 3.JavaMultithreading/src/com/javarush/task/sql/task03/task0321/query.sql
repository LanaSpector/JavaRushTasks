select *
from customers
         join orders on (customers.customer_id = orders.customer.id)
where orders.total_cost > 100;