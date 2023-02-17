"""
2개로 분할한다 -> 남은 신장이 1개가 남을때 까지 최소신장 연결
"""
import sys
import heapq

N, V = map(int, sys.stdin.readline().split())
queue = []
parent = [i for i in range(N + 1)]
span = 0
cnt = N-1

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    root_a = find(a)
    root_b = find(b)
    if root_a < root_b:
        parent[root_b] = root_a
    else:
        parent[root_a] = root_b


for i in range(V):
    start, end, cost = map(int, sys.stdin.readline().split())
    heapq.heappush(queue, [cost, start, end])

while queue and cnt > 1:
    cost, start, end = heapq.heappop(queue)
    if find(start) != find(end):
        union(start, end)
        span += cost
        cnt -= 1
print(span)
