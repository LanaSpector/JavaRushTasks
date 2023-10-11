select department, count(*) as number_of_employee
from employee
group by department;