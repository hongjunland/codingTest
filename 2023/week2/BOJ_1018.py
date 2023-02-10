import sys


def get_diff(mat, row, col, size):
    cnt_a = 0
    cnt_b = 0
    chessA = [
        'WBWBWBWB',
        'BWBWBWBW',
        'WBWBWBWB',
        'BWBWBWBW',
        'WBWBWBWB',
        'BWBWBWBW',
        'WBWBWBWB',
        'BWBWBWBW',
    ]
    chessB = [
        'BWBWBWBW',
        'WBWBWBWB',
        'BWBWBWBW',
        'WBWBWBWB',
        'BWBWBWBW',
        'WBWBWBWB',
        'BWBWBWBW',
        'WBWBWBWB',
    ]
    for i in range(size):
        for j in range(size):
            if not mat[row + i][col + j] == chessA[i][j]:
                cnt_a += 1
            if not mat[row + i][col + j] == chessB[i][j]:
                cnt_b += 1

    return min(cnt_a, cnt_b)


if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())

    Mat = []

    SIZE = 8
    for i in range(N):
        Mat.append(list(sys.stdin.readline().strip()))
    result = N * M
    for i in range(N - SIZE + 1):
        for j in range(M - SIZE + 1):
            result = min(result, get_diff(Mat, i, j, SIZE))
    print(result)
