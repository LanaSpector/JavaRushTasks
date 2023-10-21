select *
from film_directors
         right join
         (select title,director_id from films where year_of_release > 1990) as film
         on film_directors.id = film.director_id
where film_directors.country = 'USA'
limit 5;