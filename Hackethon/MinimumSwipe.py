# https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays

# Complete the minimumSwaps function below.
def minimumSwaps(arr):
    swaps = 0
    i = 0

    while i < len(arr):
        # If the current element is not in its correct position, swap it
        if arr[i] != i + 1:
            temp = arr[i]
            arr[i] = arr[temp - 1]
            arr[temp - 1] = temp
            swaps += 1
        else:
            i += 1

    return swaps

# Example usage:
my_list = [5, 1, 4, 2, 3]
total_swaps = minimumSwaps(my_list)
print("Sorted List:", my_list)
print("Total Swaps:", total_swaps)