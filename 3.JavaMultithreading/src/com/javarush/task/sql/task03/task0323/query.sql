select customers.last_name as surname,
       orders.order_id
from customers
         left join orders on customers.id = orders.order_id;