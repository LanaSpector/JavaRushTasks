select if(position = 'manager', if(salary > 10000, 'good', 'bad'), if(salary > 5000, 'good', 'bad'))
from employee
where city = 'London';