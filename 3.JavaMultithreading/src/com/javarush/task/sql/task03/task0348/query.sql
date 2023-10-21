with grossed_total as (select SUM(grossed) as total from films)
select avg(total) as average_grossed from grossed_total;