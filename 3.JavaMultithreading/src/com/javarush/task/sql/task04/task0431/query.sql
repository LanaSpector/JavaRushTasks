select DAYNAME(date), count(*) from event where type = 'REGISTRATION' group by DAYNAME(date)
order by count(*) desc
limit 1;
