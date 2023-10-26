select YEAR(date), MONTH(date), DAY(date), SUM(total) from data group by YEAR(date), MONTH(date), DAY(date);

