select customers.email, orders.*
from customers
         right join orders on customers.customer_id = orders.customers_id;