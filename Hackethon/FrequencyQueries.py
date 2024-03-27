from collections import Counter

# Solution 1:
def freqQuery(queries):
    lst = []
    dic = Counter()
    result = []
    
    for q in queries:
        opt, data = q[0], q[1]
        print(dic)
        if opt == 1:
            lst.append(data)
            dic[data] += 1
        elif opt == 2:
            if lst and data in lst:
                lst.remove(data)
                dic[data] -= 1
        elif opt == 3:
            # Check if any element has frequency greater than or equal to data
            exists = any(value == data for value in dic.values())
            result.append(1 if exists else 0)

    return result

# Solution2:
def freqQuery1(queries):
    data = dict()
    ans = list()
    for query in queries:
        op = query[0]
        value = query[1]
        if op == 1:
            data[value] = data.get(value, 0) + 1
        elif op == 2:
            if data.get(value, 0) > 0:
                data[value] -= 1
        elif op == 3:
            for v in data.values():
                if v == value:
                    ans.append(1)
                    break
            else:
                ans.append(0)
    return ans

# Example usage:
queries = [
    (1,1)    ,
(2,2)      ,
(3,2)                 ,
(1,1)       ,
(1,1)      ,
(2,1)     ,
(3,2)
]

ans = freqQuery(queries)
print(ans)

print(freqQuery1(queries))