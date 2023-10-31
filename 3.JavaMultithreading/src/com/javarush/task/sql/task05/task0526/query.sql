select book.publication_year, book.isbn, book.title, author.full_name as author, publisher.name as publisher
from book
         left join author on book.author_id = author.id
         left join publisher on book.author_id = publisher.id;
