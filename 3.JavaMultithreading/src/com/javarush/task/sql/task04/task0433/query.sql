select YEAR(date), MONTH(date), DAY(date), count(*) from event
where user_id = 3 and type = 'SOLVE_TASK' and status = 'OK'
group by YEAR(date), MONTH(date), DAY(date);
