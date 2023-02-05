
"""
N : number of node
M : number of vertex
V : starting number(node)
G : graph

input example
4 5 1
1 2
1 3
1 4
2 4
3 4

output example
1 2 4 3
1 2 3 4
"""

import sys
from collections import deque

N, M, V = map(int, sys.stdin.readline().split())
G = [[] for _ in range(N + 1)]

for i in range(M):
    left, right = map(int, sys.stdin.readline().split())
    G[left].append(right)
    G[right].append(left)

# recursive function
def dfs(graph, current_node, visited, result=[]):
    result.append(current_node)
    visited[current_node] = True
    for next_node in graph[current_node]:
        if not visited[next_node]:
            dfs(graph, next_node, visited, result)
    return result


def bfs(graph, start_node, visited, result=[]):
    visited[start_node] = True
    queue = deque([start_node])
    while queue:
        current_node = queue.popleft()
        result.append(current_node)
        for next_node in graph[current_node]:
            if not visited[next_node]:
                queue.append(next_node)
                visited[next_node] = True
    return result


print(*dfs(G, V, [False] * (N + 1)))
print(*bfs(G, V, [False] * (N + 1)))
