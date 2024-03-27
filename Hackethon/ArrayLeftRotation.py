""" Sample Input
5 4
1 2 3 4 5
Sample Output
5 1 2 3 4  """

def rotLeft(arr, d):
    # Write your code here
    n = len(arr)
    print(d % n)

    rotated_arr = arr[d :] + arr[:d ]
    return rotated_arr

# Example usage:
original_array = [1, 2, 3, 4, 5]
d_steps = 4

rotated_array = rotLeft(original_array, d_steps)

print("Original Array:", original_array)
print(f"Left rotated by {d_steps} steps:", rotated_array)

