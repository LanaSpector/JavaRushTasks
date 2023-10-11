select position, GROUP_CONCAT(name)
from employee
group by position
having position = '%developer%';