select ip_from, ip_to, country_name
from ip2country
order by ip_to DESC
limit 1 offset 74;
