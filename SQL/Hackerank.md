

## Basic Join

[Population Census](https://www.hackerrank.com/challenges/asian-population/problem) - Medium

Given the CITY and COUNTRY tables, query the sum of the populations of all cities where the CONTINENT is 'Asia'.

Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
```sql
select sum(city.population) from city left join country on city.countrycode = country.code   where CONTINENT like "%Asia%";
```

[African Cities](https://www.hackerrank.com/challenges/african-cities/problem?isFullScreen=true) - Easy

Given the CITY and COUNTRY tables, query the names of all cities where the CONTINENT is 'Africa'.

Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
```sql
select name from city where countrycode IN (select code from country where CONTINENT = 'Africa');
```

[Average Population of Each Continent](https://www.hackerrank.com/challenges/average-population-of-each-continent/problem?isFullScreen=true) - Easy

Given the CITY and COUNTRY tables, query the names of all the continents (COUNTRY.Continent) and their respective average city populations (CITY.Population) rounded down to the nearest integer.

Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
```sql
select COUNTRY.Continent , floor(avg(CITY.population)) from COUNTRY ,CITY where CITY.countrycode =  COUNTRY.code group by COUNTRY.Continent;
```

[The Report](https://www.hackerrank.com/challenges/the-report/problem?isFullScreen=true) - Medium

Ketty gives Eve a task to generate a report containing three columns: Name, Grade and Mark. Ketty doesn't want the NAMES of those students who received a grade lower than 8. The report must be in descending order by grade -- i.e. higher grades are entered first. If there is more than one student with the same grade (8-10) assigned to them, order those particular students by their name alphabetically. Finally, if the grade is lower than 8, use "NULL" as their name and list them by their grades in descending order. If there is more than one student with the same grade (1-7) assigned to them, order those particular students by their marks in ascending order.

Write a query to help Eve.
```sql
select 
    CASE
        WHEN GRADE >= 8 THEN NAME ELSE NULL
    END,GRADE,MARKS FROM STUDENTS S
INNER JOIN GRADES G ON S.MARKS BETWEEN G.MIN_MARK AND G.MAX_MARK
ORDER BY GRADE DESC, NAME ;  
```


[Top Challenger](https://www.hackerrank.com/challenges/full-score/problem?isFullScreen=true) - Medium

Julia just finished conducting a coding contest, and she needs your help assembling the leaderboard! Write a query to print the respective hacker_id and name of hackers who achieved full scores for more than one challenge. Order your output in descending order by the total number of challenges in which the hacker earned a full score. If more than one hacker received full scores in same number of challenges, then sort them by ascending hacker_id.
``` sql
SELECT h.hacker_id, h.name
FROM submissions s
INNER JOIN challenges c ON s.challenge_id = c.challenge_id
INNER JOIN difficulty d ON c.difficulty_level = d.difficulty_level 
INNER JOIN hackers h ON s.hacker_id = h.hacker_id
WHERE s.score = d.score AND c.difficulty_level = d.difficulty_level
GROUP BY h.hacker_id, h.name, s.hacker_id  -- Add s.hacker_id to the GROUP BY clause
HAVING COUNT(s.hacker_id) > 1
ORDER BY COUNT(s.hacker_id) DESC, s.hacker_id ASC;
```

[Ollivander's Inventory](https://www.hackerrank.com/challenges/harry-potter-and-wands/problem) - Medium

Harry Potter and his friends are at Ollivander's with Ron, finally replacing Charlie's old broken wand.

Hermione decides the best way to choose is by determining the minimum number of gold galleons needed to buy each non-evil wand of high power and age. Write a query to print the id, age, coins_needed, and power of the wands that Ron's interested in, sorted in order of descending power. If more than one wand has same power, sort the result in order of descending age.
```sql
select id, age, coins_needed, wands.power from wands , 
    (SELECT w.code, age, MIN(coins_needed) as min_coins, power
    FROM Wands w, Wands_Property wp
    WHERE w.code = wp.code
    AND is_evil = 0
    GROUP BY w.code, age, power) AS min_price_table
WHERE Wands.code = min_price_table.code
AND Wands.coins_needed = min_price_table.min_coins
AND Wands.power = min_price_table.power
order by Wands.power desc, age desc;
```

[Challenges](https://www.hackerrank.com/challenges/challenges/problem?isFullScreen=true) - Medium

Julia asked her students to create some coding challenges. Write a query to print the hacker_id, name, and the total number of challenges created by each student. Sort your results by the total number of challenges in descending order. If more than one student created the same number of challenges, then sort the result by hacker_id. If more than one student created the same number of challenges and the count is less than the maximum number of challenges created, then exclude those students from the result.
```sql
WITH Counting AS (
    SELECT hacker_id, COUNT(*) as Created 
    FROM Challenges
    GROUP BY hacker_id
)
SELECT H.hacker_id, H.name, COUNT(H.hacker_id) as challenges_created
FROM Hackers H
INNER JOIN Challenges C ON H.hacker_id = C.hacker_id
GROUP BY H.hacker_id, H.name
HAVING COUNT(H.hacker_id) IN (SELECT MAX(Created) FROM Counting)
    OR COUNT(H.hacker_id) IN (SELECT Created FROM Counting GROUP BY Created HAVING COUNT(Created) = 1)
ORDER BY challenges_created DESC, H.hacker_id;
```

[Contest Leaderboard](https://www.hackerrank.com/challenges/contest-leaderboard/problem) - Medium / Basic Join

You did such a great job helping Julia with her last coding contest challenge that she wants you to work on this one, too!

The total score of a hacker is the sum of their maximum scores for all of the challenges. Write a query to print the hacker_id, name, and total score of the hackers ordered by the descending score. If more than one hacker achieved the same total score, then sort the result by ascending hacker_id. Exclude all hackers with a total score of 0 from your result.
```sql
SELECT H.hacker_id, H.name, SUM(S.max_score) total_score
FROM Hackers H INNER JOIN (
    SELECT hacker_id, challenge_id, MAX(score) max_score
    FROM Submissions
    WHERE score <> 0
    GROUP BY hacker_id, challenge_id
) S ON H.hacker_id = S.hacker_id
GROUP BY H.hacker_id, H.name
ORDER BY total_score DESC, H.hacker_id;
```

[Symmetric Pairs](https://www.hackerrank.com/challenges/symmetric-pairs/problem) - Medium / Advanced Join 

You are given a table, Functions, containing two columns: X and Y.\
Two pairs (X1, Y1) and (X2, Y2) are said to be symmetric pairs if X1 = Y2 and X2 = Y1.\
Write a query to output all such symmetric pairs in ascending order by the value of X. List the rows such that X1 ≤ Y1.

```sql
SELECT f1.X, f1.Y FROM Functions f1
INNER JOIN Functions f2 ON f1.X=f2.Y AND f1.Y=f2.X
GROUP BY f1.X, f1.Y
HAVING COUNT(f1.X)>1 or f1.X<f1.Y
ORDER BY f1.X ;
```

[](https://www.hackerrank.com/challenges/15-days-of-learning-sql/problem?isFullScreen=true)
Julia conducted a 15 days of learning SQL contest. The start date of the contest was March 01, 2016 and the end date was March 15, 2016.

Write a query to print total number of unique hackers who made at least  submission each day (starting on the first day of the contest), and find the hacker_id and name of the hacker who made maximum number of submissions each day. If more than one such hacker has a maximum number of submissions, print the lowest hacker_id. The query should print this information for each day of the contest, sorted by the date.