"""
input:
13
30 13 15 16 18 22 23 2 5 6 1 17 45 23

output:
4
"""
import sys

target = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()
left = 0
right = len(nums) - 1
while left <= right:
    mid = (left + right) // 2
    if nums[mid] == target:
        right = mid
        break
    elif nums[mid] > target:
        right = mid - 1
    else:
        left = mid + 1
print(right)
