select YEAR(date_of_birth), MONTH(date_of_birth), COUNT(*) from employee GROUP BY YEAR(date_of_birth), MONTH(date_of_birth);
