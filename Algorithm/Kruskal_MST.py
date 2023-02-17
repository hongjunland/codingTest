"""
N: number of nodes
V: number of vertices
queue: heap
result: minimum span

input:
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8

output:
23
"""
import sys
import heapq

N = int(sys.stdin.readline())
V = int(sys.stdin.readline())
queue = []
parent = [i for i in range(N + 1)]
result = 0


def find(x):
    if x != parent[x]:
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
    a, b, c = map(int, sys.stdin.readline().split())
    heapq.heappush(queue, [c, a, b])

while queue:
    c, a, b = heapq.heappop(queue)
    if find(a) != find(b):
        union(a, b)
        result += c
print(result)
