select YEAR(date_of_birth), MONTH(date_of_birth)
from employee
where month(date_of_birth) in (12, 01, 02);