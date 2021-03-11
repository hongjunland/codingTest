from collections import deque

n, m = map(int , input().split())

graph = []
for i in range(n):
  graph.append(list(map(int,input())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(x,y):
  queue = deque()
  queue.append((x,y))
  while queue:
    x, y = queue.popleft()

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      # 공간 벗어남
      if nx < 0 or ny < 0 or nx >= n or ny >= m:
        continue
      # 벽 무시
      if graph[nx][ny] == 0:
        continue
      # 해당 노드 처음 방문시 최단거리 기록
      if graph[nx][ny] == 1:
        graph[nx][ny] = graph[x][y] + 1
        queue.append((nx,ny))

  return graph[n-1][m-1]
print(bfs(0,0))

