def array_manipulation(n, queries):
    max_value = 0
    x = 0

    a = [0] * (n + 1)
    print(a)
    for query in queries:
        p, q, sum_value = query
        a[p-1] += sum_value
        if q < n:
            a[q] -= sum_value
        print(a)
    
    for value in a:
        x += value
        max_value = max(max_value, x)

    return max_value

# Example usage:
queries = [
    [1, 5, 3],
    [4, 8, 7],
    [6, 9, 1]
]

n = 10
result = array_manipulation(n, queries)

print("Maximum value after array manipulation:", result)