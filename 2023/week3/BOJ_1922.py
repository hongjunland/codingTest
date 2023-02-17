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
