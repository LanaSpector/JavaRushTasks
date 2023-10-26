select * from event where date_time between DATE_SUB(CURDATE(), 2 WEEK) and CURDATE();
