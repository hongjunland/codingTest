import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

Mat = []
for i in range(N):
    Mat.append(list(map(int, sys.stdin.readline().split())))
answer = 0


def bfs(_row, _col):
    _queue = deque([[_row, _col]])
    Visited[_row][_col] = True
    _iceberg = [[_row, _col]]
    while _queue:
        _r, _c = _queue.popleft()
        for dr, dc in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
            _nr = _r + dr
            _nc = _c + dc
            if 0 <= _nr < N and 0 <= _nc < M and not Visited[_nr][_nc] and Mat[_nr][_nc] > 0:
                _queue.append([_nr, _nc])
                Visited[_nr][_nc] = True
                _iceberg.append([_nr, _nc])
    return _iceberg


def melt(_row, _col):
    _result = 0
    for dr, dc in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
        _nr = _row + dr
        _nc = _col + dc
        if 0 <= _nr < N and 0 <= _nc < M and Mat[_nr][_nc] > 0:
            _result += 1
    return 4 - _result


year = 0
while True:
    Visited = [[False] * M for _ in range(N)]
    icebergs = []
    newMat = [Mat[i].copy() for i in range(N)]
    for i in range(N):
        for j in range(M):
            if Mat[i][j] > 0 and not Visited[i][j]:
                icebergs.append(bfs(i, j))
    if len(icebergs) > 1:
        answer = year
        break
    if len(icebergs) == 0:
        break
    for iceberg in icebergs:
        for r, c in iceberg:
            newMat[r][c] = max(Mat[r][c] - melt(r, c), 0)
    Mat = newMat
    year += 1

print(answer)
