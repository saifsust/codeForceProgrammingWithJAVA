select concat(name, concat('(',concat(upper(substr(occupation, 1, 1)),')'))) from occupations order by name asc;

select concat('There are a total of ', concat(concat(count(occupation), ' '), concat(lower(occupation), 's.')))
  from occupations group by occupation order by count(occupation) asc;
