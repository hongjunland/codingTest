from collections import deque

def solution(N, road, K):
    graph = {}
    for i in range(1, N+1):
        graph[i] = {}
        
    for item in road:
        start, end, weight = item
        if not end in graph[start] or graph[start][end] > weight:
            graph[start][end] = weight
            graph[end][start] = weight

    answer = bfs(N, graph, K)
    return answer

def bfs(N, graph, K):
    answer = 0
    distance = [1000000]*(N+1)
    queue = deque()
    queue.appendleft([1, 0])
    distance[1] = 0
    while queue:
        current, weight = queue.popleft()
        for next in graph[current].keys():
            if graph[current][next] + weight <= distance[next]:
                queue.appendleft([next, graph[current][next] + weight])
                distance[next] = graph[current][next] + weight
                
    for i in range(1, N+1):
        if distance[i] <= K:
            answer+=1
            
    return answer