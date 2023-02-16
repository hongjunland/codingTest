"""

N: number of values
M: subtotal
data: list of numbers

input:
8 12
1 3 4 5 2 5 3 2

output:
3
"""
import sys

N, M = map(int, sys.stdin.readline().split())
data = list(map(int, sys.stdin.readline().split()))
count = 0
subtotal = 0
right = 0

for left in range(N):
    # left < right
    while subtotal < M and right < N:
        subtotal += data[right]
        right += 1
    if subtotal == M:
        count += 1
    subtotal -= data[left]

print(count)
