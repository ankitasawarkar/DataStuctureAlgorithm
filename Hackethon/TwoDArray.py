

def hourglassSum(arr):
    max_sum = float('-inf')
    size = 3
    for i in range(0, len(arr)-size):
        for j in range(0, len(arr[0])-size):
            current_sum = sum(arr[i][j:j+3]) + arr[i+1][j+1] + sum(arr[i+2][j:j+3])
            max_sum = max(max_sum, current_sum)
    return max_sum

arr = [
    [1, 1, 1, 0, 0, 0],
    [0, 1, 0, 0, 0, 0],
    [1, 1, 1, 0, 0, 0],
    [0, 0, 2, 4, 4, 0],
    [0, 0, 0, 2, 0, 0],
    [0, 0, 1, 2, 4, 0]
]

result = hourglassSum(arr)
print(result)