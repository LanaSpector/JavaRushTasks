select top_retailers.name as retailer, top_retailers.hq_location as retailer_hq, supplier.country as supplier_country
from top_retailers,
     suppliers;