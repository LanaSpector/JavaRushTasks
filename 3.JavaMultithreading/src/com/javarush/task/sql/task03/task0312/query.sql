select top_retailers.rank                as company_rank,
       top_retailers.name                as company_rank,
       suppliers.annual_revenue_billions as supplier_revenue
from top_retailers,
     suppliers where supplier_revenue > 25;