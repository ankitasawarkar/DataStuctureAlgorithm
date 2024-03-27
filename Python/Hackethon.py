def getMaximumMEX(arr):
    arr.sort()  # Sort the array in non-decreasing order
    n = len(arr)
    
    # Iterate through the sorted array and try to reduce each element
    for i in range(n):
        if arr[i] > i:
            return i  # If cannot reduce to index, return the current index
    
    # If all elements can be reduced to their indices, return n as the maximum MEX
    return n

if __name__ == "__main__":
    # Sample Case 0
    arr1 = [3, 1, 2, 2]
    print(getMaximumMEX(arr1))  # Output: 3

    # Sample Case 1
    arr2 = [2, 0, 0]
    print(getMaximumMEX(arr2))  # Output: 1

