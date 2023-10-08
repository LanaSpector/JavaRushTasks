select if(age >= 20, 'adult', if(age <= 12, 'child', 'teenager'))
from customers
limit 5;