# Project Euler
import sys

# 1: Multiples of 3 and 5
""" https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem
Sample Input
2
10
100
Sample Output 
23
2318 """
t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    
    """  sum = 0; 
    for i in range(3, n):
        if(i%3 == 0) | (i % 5 == 0):
            sum += i;
        print(sum) 

    # Error: Time Limit Exceed.        
    """

    def sum_of_multiples(x, limit):
        num_multiples = (limit - 1) // x
        return x * num_multiples * (num_multiples + 1) // 2
    
    result = sum_of_multiples(3, n) + sum_of_multiples(5, n) - sum_of_multiples(15, n)
    print(result)


