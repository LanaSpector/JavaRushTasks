select *
from authors
where full_name not like
      (select first_name || ' ' || last_name from authors where last_name = 'Shakespeare');