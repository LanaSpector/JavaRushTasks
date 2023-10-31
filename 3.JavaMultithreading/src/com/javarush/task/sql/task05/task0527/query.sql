select distinct book.title from book left join author on book.author_id = author.id
where author.full_name = 'Edgar Allan Poe';