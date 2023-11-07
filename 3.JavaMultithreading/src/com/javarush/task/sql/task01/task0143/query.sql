select id, identifier, description
from parts
order by identifier asc, required desc, description desc
limit 7;

