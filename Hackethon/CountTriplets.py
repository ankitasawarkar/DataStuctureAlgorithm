def countTriplets(arr, r):
    count = 0
    dict = {}
    dictPairs = {}

    for i in reversed(arr):
            
        if i*r in dictPairs:
                count += dictPairs[i*r]
                
        if i*r in dict:
                dictPairs[i] = dictPairs.get(i, 0) + dict[i*r]

        dict[i] = dict.get(i, 0) + 1
    #print(dict, dictPairs)
    

    return count

print(countTriplets([1 ,3 ,9, 9 ,27 ,81], 3))