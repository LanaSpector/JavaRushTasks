select book.isbn, book.title from book join author on book.author_id = author.id
where author.last_name like 'S%';
