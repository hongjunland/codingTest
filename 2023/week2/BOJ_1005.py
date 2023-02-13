"""
input:
2
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4
8 8
10 20 1 5 8 7 1 43
1 2
1 3
2 4
2 5
3 6
5 7
6 7
7 8
7

output:
120
39
"""
import sys
from collections import deque


def bfs(graph, times, degree_list, target):
    queue = deque([])
    dp = [0 for _ in range(len(graph))]
    for i in range(1, len(graph)):
        if degree_list[i] == 0:
            queue.append(i)
            dp[i] = times[i - 1]
    while queue:
        current_node = queue.popleft()
        for next_node in graph[current_node]:
            degree_list[next_node] -= 1
            dp[next_node] = max(dp[next_node], dp[current_node] + times[next_node - 1])
            if degree_list[next_node] == 0:
                queue.append(next_node)
    return dp[target]


"""
N : The number of node
K : The number of vertex
G : Graph (2D)
Degree_list = The list of in-degree
W : Target node
"""


def solution():
    N, K = map(int, sys.stdin.readline().split())
    Delay_times = list(map(int, sys.stdin.readline().split()))
    G = [[] for _ in range(N + 1)]
    Degree_list = [0 for _ in range(len(G))]
    for _ in range(K):
        pre, post = map(int, sys.stdin.readline().split())
        G[pre].append(post)
        Degree_list[post] += 1
    W = int(sys.stdin.readline().strip())
    return bfs(G, Delay_times, Degree_list, W)


if __name__ == '__main__':
    T = int(sys.stdin.readline())
    for _ in range(T):
        print(solution())
