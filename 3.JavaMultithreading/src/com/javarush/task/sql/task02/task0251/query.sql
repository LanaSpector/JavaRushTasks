select department, position, count(*) total
from employee
group by department, position
having total = 1 or position = 'manager'
limit 2
offset 1;