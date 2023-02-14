import sys


def get_result(nums, quotient):
    result = 0
    for item in nums:
        result += item // quotient
    return result


K, N = map(int, sys.stdin.readline().split())
line_list = []
for i in range(K):
    num = int(sys.stdin.readline())
    line_list.append(num)
left = 1
right = sum(line_list) // N

while left <= right:
    mid = (left + right) // 2
    if get_result(line_list, mid) >= N:
        left = mid + 1
    elif get_result(line_list, mid) < N:
        right = mid - 1
print(right)
