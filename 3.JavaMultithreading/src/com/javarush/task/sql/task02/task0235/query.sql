select YEAR(date_of_birth) as year_of_birth, count(*)
from employee
where position = '%developer%'
group by year_of_birth;