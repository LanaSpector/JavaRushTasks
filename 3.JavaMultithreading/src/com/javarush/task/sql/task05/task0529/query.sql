select author.full_name, count(publisher.name) as publishers,
from book
         join author on book.author_id = author.id
         join publisher on book.publisher_id = publisher.id
group by author.full_name;
