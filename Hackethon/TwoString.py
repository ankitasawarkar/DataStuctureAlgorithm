#
# Complete the 'twoStrings' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING s1
#  2. STRING s2
#

def twoStrings(s1, s2):
    # Write your code here
    if set(s1) & set(s2):
        return "YES"
    else: 
        return "NO"
    
    # return 'YES' if set(s1) & set(s2) else 'NO'
    
print(twoStrings("Hello", "world"))

print(twoStrings("hi", "world"))