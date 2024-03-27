#
# Complete the 'checkMagazine' function below.
#
# The function accepts following parameters:
#  1. STRING_ARRAY magazine
#  2. STRING_ARRAY note
#

# Solution 1: Some cases failed
def checkMagazine(magazine, note):
    # Write your code here
    s1, s2 = {}, {}
    for w in magazine.split(" "):
        print("word:",w)
        s1.setdefault(w,0)
        s1[w]+=1
    for w in note.split(" "):
        s2.setdefault(w, 0)
        s2[w]+=1
    count=0
    for k, v in s2.items():
        if k in s1.keys() and v == s1.get(k, 0):
            count+=1

    if count == len(s2):
        print("Yes")
    else:
        print("No")
    

# Solution 2:
from collections import defaultdict

def checkMagazine1(magazine, ransom):
    print(magazine)
    dicty = defaultdict(int)
    for word in magazine:
        dicty[word]+=1
    for word in ransom: 
        if dicty[word]==0 : print("No") 
        dicty[word]-=1
    print("Yes")  




# Solution 3
from collections import Counter

def checkMagazine2(magazine, rasom):
    return print("Yes") if (Counter(rasom) - Counter(magazine)) == {} else print("No")

l1 = "give me one grand today night".split(" ")
l2 = "give one grand today".split(" ")
checkMagazine2(l1,l2)
