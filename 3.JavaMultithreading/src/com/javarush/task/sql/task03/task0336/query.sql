select year_born
from authors
where authors.year_born <= (select max(date_released) from books);