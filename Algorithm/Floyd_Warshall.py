import sys

N = int(sys.stdin.readline())   # number of nodes
M = int(sys.stdin.readline())   # number of vertices
graph = [[sys.maxsize] * (N + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, N+ 1):
        if i == j:
            graph[i][j] = 0

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for k in range(1, N + 1):
    for a in range(1, N + 1):
        for b in range(1, N + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
print()
for a in range(1, N + 1):
    print(graph[a][1:])
