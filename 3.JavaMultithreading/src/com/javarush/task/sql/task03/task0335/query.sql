select author.country as author_country, count(book.book_id) as book_count
from authors as author
         join books as book on author.id = book.author_id
where book.genre = 'novel'
group by author_country
having book_count > 2;