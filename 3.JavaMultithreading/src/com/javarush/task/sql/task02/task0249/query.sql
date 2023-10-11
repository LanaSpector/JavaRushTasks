select department, position, count(*) total
from employee
group by department, position
having position = 'backend developer'and total = 1;