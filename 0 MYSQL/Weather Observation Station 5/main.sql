select city, length(station.city) from station where 
length(station.city) =(select max(length(station.city)) from station) or
length(station.city) = (select min(length(station.city)) from station)
order by length(station.city) desc, station.city asc limit 0,2

