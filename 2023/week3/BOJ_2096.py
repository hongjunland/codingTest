import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
Max_current = arr.copy()
Min_current = arr.copy()

for i in range(N - 1):
    Max_next = [0] * 3
    Min_next = [sys.maxsize] * 3
    arr = list(map(int, sys.stdin.readline().split()))
    for j in range(3):
        if j - 1 >= 0:
            Max_next[j - 1] = max(Max_next[j - 1], arr[j - 1] + Max_current[j])
            Min_next[j - 1] = min(Min_next[j - 1], arr[j - 1] + Min_current[j])
        if j + 1 < 3:
            Max_next[j + 1] = max(Max_next[j + 1], arr[j + 1] + Max_current[j])
            Min_next[j + 1] = min(Min_next[j + 1], arr[j + 1] + Min_current[j])
        Max_next[j] = max(Max_next[j], arr[j] + Max_current[j])
        Min_next[j] = min(Min_next[j], arr[j] + Min_current[j])
    Max_current = Max_next
    Min_current = Min_next

print(max(Max_current), min(Min_current))
