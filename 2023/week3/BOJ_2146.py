import sys
from collections import deque

N = int(sys.stdin.readline())
Mat = []
islands = []
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
sequence = 0
for i in range(N):
    Mat.append(list(map(int, sys.stdin.readline().split())))


def get_island(row, col, id):
    queue = deque([[row, col]])
    result = [[row, col]]
    Mat[row][col] = id
    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <= nc < N and Mat[nr][nc] == 1:
                queue.append([nr, nc])
                result.append([nr, nc])
                Mat[nr][nc] = id
    return result


for i in range(N):
    for j in range(N):
        if Mat[i][j] == 1:
            islands.append(get_island(i, j, 's' + str(sequence)))
            sequence += 1


def bfs(row, col, id):
    queue = deque([[row, col, 0]])
    new_mat = [Mat[i].copy() for i in range(N)]
    while queue:
        r, c, cost = queue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <= nc < N and Mat[nr][nc] != id:
                if isinstance(Mat[nr][nc], str):
                    return cost
                if new_mat[nr][nc] == 0:
                    queue.append([nr, nc, cost + 1])
                    new_mat[nr][nc] = cost + 1
    return sys.maxsize


result = sys.maxsize

for i, island in enumerate(islands):
    for row, col in island:
        result = min(result, bfs(row, col, Mat[row][col]))

print(result)