import sys

M, N, H = map(int, sys.stdin.readline().split())

Mat = []
dh = [0, 0, 0, 0, -1, 1]
dr = [-1, 0, 1, 0, 0, 0]
dc = [0, 1, 0, -1, 0, 0]
tasks = []
state = [0, 0, 0]
answer = 0
for h in range(H):
    Mat.append([])
    for r in range(N):
        row_line = list(map(int, sys.stdin.readline().split()))
        for c in range(M):
            # value : -1 , 0 , 1 => index: 0, 1 , 2
            state[row_line[c] + 1] += 1
            if row_line[c] == 1:
                state[2] += 1
                tasks.append([h, r, c])
        Mat[h].append(row_line)
while state[1] > 0:
    new_tasks = []
    answer += 1
    flag = False
    for task in tasks:
        h, r, c = task
        for i in range(6):
            nh = h + dh[i]
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nh < H and 0 <= nr < N and 0 <= nc < M and Mat[nh][nr][nc] == 0:
                new_tasks.append([nh, nr, nc])
                Mat[nh][nr][nc] = 1
                state[1] -= 1
                state[2] += 1
                flag = True
    tasks = new_tasks
    if not flag:
        answer = -1
        break
print(answer)
