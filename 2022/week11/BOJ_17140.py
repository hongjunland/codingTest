import sys


def solution():
    r, c, k = map(int, sys.stdin.readline().split())
    mat = []
    for i in range(3):
        row = list(map(int, sys.stdin.readline().split()))
        mat.append(row)
    time = 0
    while time <= 100:
        if r <= len(mat) and c <= len(mat[0]) and mat[r-1][c-1] == k:
            return time
        if len(mat) >= len(mat[0]):
            mat = sort_by_row(mat)
        else:
            mat = transpose_mat(mat)
            mat = sort_by_row(mat)
            mat = transpose_mat(mat)
        time += 1
    return -1


def sort_by_row(mat):
    max_size = 0
    for i, row in enumerate(mat):
        counter = dict()
        for j, col in enumerate(row):
            if col == 0:
                continue
            if col not in counter:
                counter[col] = 0
            counter[col] += 1
        mat[i] = dict_to_arr(counter)
        mat[i].sort(key=lambda x: (x[1], x[0]))
        mat[i] = flat(mat[i])
        max_size = max(max_size, len(mat[i]))
    arr = expansion(mat, max_size)
    return arr


def dict_to_arr(_dict):
    arr = []
    for key in _dict.keys():
        arr.append([key, _dict[key]])
    return arr


def expansion(arr, size):
    new_arr = []
    for i, item in enumerate(arr):
        for j in range(size-len(item)):
            item.append(0)
        new_arr.append(item)
    return new_arr


def flat(arr):
    new_arr = []
    for item in arr:
        new_arr.append(item[0])
        new_arr.append(item[1])
    return new_arr


def transpose_mat(mat):
    row = len(mat)
    col = len(mat[0])
    new_mat = [[0 for _ in range(row)] for _ in range(col)]
    for i in range(row):
        for j in range(col):
            new_mat[j][i] = mat[i][j]
    return new_mat


if __name__ == '__main__':
    print(solution())
