"""
The topological_sort
N : The number of node
K : The number of vertex
G : Graph (2D)
Degree_list = The list of in-degree

input:
4 4
1 2
1 3
2 4
3 4


output:
1 2 3 4
"""
import sys
from collections import deque


def topological_sort():
    N, V = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(N + 1)]
    degree_list = [0 for _ in range(len(graph))]
    result = []
    for _ in range(V):
        pre, post = map(int, sys.stdin.readline().split())
        graph[pre].append(post)
        degree_list[post] += 1
    queue = deque([])
    for i in range(1, N + 1):
        if degree_list[i] == 0:
            queue.append(i)
    while queue:
        current_node = queue.popleft()
        result.append(current_node)
        for next_node in graph[current_node]:
            degree_list[next_node] -= 1
            if degree_list[next_node] == 0:
                queue.append(next_node)
    return result


if __name__ == '__main__':
    print(*topological_sort())
