with tempTable(averageDOB) as (select avg(year_born) from film_directors)
select id, full_name, year_born from film_directors join tempTable
                                                         on film_directors.year_born < tempTable.averageDOB;