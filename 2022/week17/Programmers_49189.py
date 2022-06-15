from collections import deque

def solution(n, edge):
    answer = 0
    dist = [-1] * (n+1)
    graph = [[] for _ in range(n+1)]
    for item in edge:
        start, end = item
        graph[start].append(end)
        graph[end].append(start)
    dist = bfs(1,graph,dist)
    max_dist = max(dist)
    for item in dist:
        if max_dist == item:
            answer += 1
    return answer

def bfs(start ,graph, dist):
    queue = deque([start])
    dist[start] = 0
    while queue:
        current = queue.popleft()
        for next in graph[current]:
            if dist[next] == -1:
                queue.append(next)
                dist[next] = dist[current]+1
    return dist