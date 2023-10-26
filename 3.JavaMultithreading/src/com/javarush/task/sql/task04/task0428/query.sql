select * from event where MONTH(CURDATE()) = MONTH(date_time) and YEAR(CURDATE()) = YEAR(date_time);
