select author.full_name, count(distinct book.title) as books
from author
         join book on
        book.author_id = author.id
group by author.full_name
having books > 1;