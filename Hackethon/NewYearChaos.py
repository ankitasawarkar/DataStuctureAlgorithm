#
# Complete the 'minimumBribes' function below.
#https://www.hackerrank.com/challenges/new-year-chaos/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
# The function accepts INTEGER_ARRAY q as parameter.
""" Sample Input

STDIN       Function
-----       --------
2           t = 2
5           n = 5
2 1 5 3 4   q = [2, 1, 5, 3, 4]
5           n = 5
2 5 1 3 4   q = [2, 5, 1, 3, 4]
Sample Output

3
Too chaotic """
#

def minimumBribes(q):
    # Write your code here
    briber = 0
    for i in range(len(q)):
        if q[i] - (i+1) > 2:
            print("Too chaotic")
            return
        for j in range(max(q[i]-2, 0), i ):
            if q[j] > q[i] :
                briber +=1
    
    print(briber)