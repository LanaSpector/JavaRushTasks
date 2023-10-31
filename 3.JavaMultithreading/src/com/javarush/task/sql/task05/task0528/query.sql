select distinct publisher.name
from book
         join author on book.author_id = author.id
         join publisher on book.publisher_id = publisher.id
where author.full_name = 'Mark Twain';
