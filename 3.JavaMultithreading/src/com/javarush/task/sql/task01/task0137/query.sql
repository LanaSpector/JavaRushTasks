select distinct country_name
from ip2country
where country_name not like '% %';
