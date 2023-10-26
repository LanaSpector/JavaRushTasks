select YEAR(date), MONTH(date), DAY(date), count(*) from event group by YEAR(date), MONTH(date), DAY(date)
having count(*) > 5;
