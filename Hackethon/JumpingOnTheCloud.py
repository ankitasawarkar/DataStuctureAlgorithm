#
# Complete the 'jumpingOnClouds' function below.
# https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY c as parameter.
#

def jumping_on_clouds(c):
    jump = 0
    count = 0
    
    while count < len(c) - 1:
        jump += 1
        if count + 2 < len(c) and c[count + 2] == 0:
            count += 2
        else:
            count += 1
            
    return jump

# Example usage:
clouds = [0, 0, 1, 0, 0, 1, 0]
result = jumping_on_clouds(clouds)
print("Number of jumps:", result)