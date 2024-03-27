#
# Complete the 'countingValleys' function below.
# https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER steps
#  2. STRING path
#

def countingValleys(steps, path):
    level = 0
    valleys = 0

    for step in path:
        if step == 'U':
            level += 1
        else:
            level -= 1

        if step == 'U' and level == 0:
            valleys += 1

    return valleys

# Example usage:
steps = 8
path = "UDDDUDUU"

# Taking input from the user
steps = int(input("Enter the number of steps: "))
path = input("Enter the path sequence: ")

result = countingValleys(steps, path)

print("Number of valleys traversed:", result)


