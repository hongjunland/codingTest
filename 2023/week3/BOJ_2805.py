import sys

N, M = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()

left = 0
right = nums[N - 1]

while left <= right and left <= nums[N-1]:
    total = 0
    mid = (left + right) // 2
    for tree in nums:
        if tree > mid:
            total += tree - mid
    if total >= M:
        left = mid + 1
    elif total < M:
        right = mid - 1
print(right)