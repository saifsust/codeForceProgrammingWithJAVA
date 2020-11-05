select distinct(city) from station where 
id in (select distinct(id) from station where city like "a%") or
id in (select distinct(id) from station where city like "e%") or
id in (select distinct(id) from station where city like "i%") or
id in (select distinct(id) from station where city like "o%") or
id in (select distinct(id) from station where city like "u%");
