import sys

N = int(sys.stdin.readline())
Mat = [[] for i in range(N)]

for i in range(N):
    Mat[i] = list(map(int, sys.stdin.readline().split()))
Result = [0, 0, 0]


def recursive(row, col, size):
    if size == 1:
        Result[Mat[row][col] + 1] += 1
    else:
        if is_same(row, col, size):
            Result[Mat[row][col] + 1] += 1
        else:
            for i in range(0, size, size // 3):
                for j in range(0, size, size // 3):
                    recursive(row + i, col + j, size // 3)


def is_same(row, col, size):
    for i in range(size):
        for j in range(size):
            if not Mat[row][col] == Mat[row + i][col + j]:
                return False
    return True


recursive(0, 0, N)

for i in range(3):
    print(Result[i])
