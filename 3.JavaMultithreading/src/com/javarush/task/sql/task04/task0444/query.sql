select concat(city, '-', char_length(city)) from cities order by char_length(city) limit 3;
