import sys
import heapq

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
cost = [sys.maxsize for i in range(N + 1)]
graph = [[] for _ in range(N + 1)]

for i in range(M):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append([b, c])
start, end = map(int, sys.stdin.readline().split())

cost[start] = 0
queue = [[0, start]]
while queue:
    current_cost, current_node = heapq.heappop(queue)
    if current_node == end:
        break
    for next_node, next_cost in graph[current_node]:
        if next_cost + current_cost < cost[next_node]:
            cost[next_node] = next_cost + current_cost
            heapq.heappush(queue, [cost[next_node], next_node])
print(cost[end])
