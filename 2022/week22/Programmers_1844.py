from collections import deque

def solution(maps):
    answer = 0
    answer = bfs([0,0],[len(maps)-1, len(maps[0])-1], maps)
    return answer

def bfs(start, end, graph):
    start_row, start_col = start
    end_row, end_col = end
    visited = [[False for _ in range(len(graph[0]))] for _ in range(len(graph))]
    queue = deque([[start, 1]])
    visited[start_row][start_col] = True
    dr = [-1,1,0,0]
    dc = [0,0,-1,1]
    while queue:
        [row, col], cost = queue.popleft()
        if row == end_row and col == end_col:
            return cost
        for i in range(4):
            nr = row+dr[i]
            nc = col+dc[i]
            if nr >= 0 and nr < len(graph) and nc >= 0 and nc < len(graph[0]) and graph[nr][nc] == 1 and not visited[nr][nc]:
                queue.append([[nr,nc], cost+1])
                visited[nr][nc] = True
    return -1
            
    