select MONTHNAME(date), count(*) from event where status on ('ERROR', 'FAILED')
group by MONTHNAME(date)
order by count(*) desc
limit 1;
