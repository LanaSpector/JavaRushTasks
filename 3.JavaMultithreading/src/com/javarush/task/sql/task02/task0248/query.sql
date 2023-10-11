select department, position, count(*) total
from employee
group by department, position
having total > 1
   and total < 4;