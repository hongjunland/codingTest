import sys

N, S = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))

left = 0
total = 0
length = 0
result = sys.maxsize
for i in range(N):
    total += nums[i]
    length += 1
    if total >= S:
        result = min(result, length)
        while total >= S:
            total -= nums[left]
            left += 1
            length -= 1
            if total >= S:
                result = min(result, length)
if result == sys.maxsize:
    result = 0
# if S == 0:
#     result = 1
print(result)
