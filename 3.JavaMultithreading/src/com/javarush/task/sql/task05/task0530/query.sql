select name, YEAR(discovery_date) as d_year, MONTHNAME(discovery_date) as d_month, DAYNAME(discovery_date) as d_day
from space.object;
