import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
parent = [i for i in range(N + 1)]


def find(num: int):
    if num != parent[num]:
        parent[num] = find(parent[num])
    return parent[num]


def union(a, b):
    root_a, root_b = find(a), find(b)
    if root_a != root_b:
        parent[root_a] = root_b


def solution():
    for i in range(1, N + 1):
        row = list(map(int, sys.stdin.readline().split()))
        for j in range(1, N + 1):
            if row[j - 1] == 1:
                union(i, j)
    route = list(map(int, sys.stdin.readline().split()))
    for i in range(1, M):
        if find(route[i]) != find(route[0]):
            return 'NO'
    return 'YES'


print(solution())
