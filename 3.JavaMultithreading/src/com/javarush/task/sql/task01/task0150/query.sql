select *
from parts
where id between 7 and 23
  and identifier is null
limit 2;