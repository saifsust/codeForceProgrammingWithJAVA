select
case
    when grade <= 7 then 'NULL'
    else name
end, grade, marks
 from students
 join grades where students.marks between grades.min_mark  and grades.max_mark
 order by grade desc, name asc,
 case
  when grade <= 7 then marks
 end  asc
