SELECT 
    CASE
        WHEN a + b <= c OR b + c <= a OR c + a <= b THEN 'Not A Triangle'
        WHEN a = b AND b = c THEN 'Equilateral'
        when a = b or b = c or c = a then 'Isosceles'
        when a != b and b != c and c != a then 'Scalene'
    END AS trainagle
FROM
    triangles
