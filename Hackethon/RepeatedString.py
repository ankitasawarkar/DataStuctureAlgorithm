#
# Complete the 'repeatedString' function below.
# https://www.hackerrank.com/challenges/repeated-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. STRING s
#  2. LONG_INTEGER n
#

def repeatedString(s: str, n: int):
    # Write your code here
    if len(s) == 1:
        return n if s == "a" else 0
    else:
        countOfA = s.count("a")
        repeats = n // len(s)
        remains = n % len(s)
        countOfAinRemains = s[:remains].count("a")
        return (countOfA * repeats) + countOfAinRemains

s = "aba"
n = 10
result = repeatedString(s, n)
print("Number of 'a' characters:", result)