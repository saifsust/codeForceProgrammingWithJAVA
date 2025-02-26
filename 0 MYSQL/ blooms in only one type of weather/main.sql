SELECT p.name, w.type FROM plant p INNER JOIN WEATHER w ON p.type = w.type WHERE w.type IN
(
    SELECT CASE WHEN count(w.type) = 1 THEN w.type END FROM plant p INNER JOIN WEATHER w ON p.type = w.type  
) 
