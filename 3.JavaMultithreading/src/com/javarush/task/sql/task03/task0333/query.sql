select a.sex as author_sex, a.country as author_country, b.copies_sold_millions as books_sold
from authors as a
         join books as b on a.author_id = b.author_id
where b.copies_sold_millions > 10
group by author_sex, author_country, books_sold
order by books_sold desc;