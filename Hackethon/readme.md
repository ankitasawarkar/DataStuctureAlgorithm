# Hackethon Problems Points
## Lucky Prisoner

The Josephus problem with a starting point of 1 and elimination every k-th person can be solved using the formula:
```
J(n,k)=SUM{ 1 if n == 1  --> (J(n−1,k)+k−1)modn+1  otherwise }
```

In the case of your problem, where prisoners are eliminated every second person (k = 2) and the starting point is 1, the formula simplifies to:
```
J(n,2)=SUM{ 1  if n=1  --->  2×(J(n/2,2)−1)   otherwise }
​```

## Sales By Match

Used 'Counter' from the 'collections' module to simplify the counting of occurrences of each color in the array.\
Removed the unnecessary 'setdefault' and replaced it with 'Counter(ar)'

​
 


