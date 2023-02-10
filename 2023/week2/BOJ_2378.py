import sys
N, M = map(int, sys.stdin.readline().split())

mat = []

for i in range(N):
    input_row = list(map(int, sys.stdin.readline().split()))
    mat.append(input_row)

for i in range(N):
    input_row = list(map(int, sys.stdin.readline().split()))
    for j in range(M):
        mat[i][j] += input_row[j]

for i in range(N):
    print(*mat[i])
