size = 0
boundary = 0

# 2020 KAKAO BLIND RECRUITMENT > 자물쇠와 열쇠
def solution(key, lock):
    global size, boundary
    size = len(key)+(len(lock)-1)*2
    lock_map = [[0]*size for _ in range(size)]
    boundary = len(key)-1

    for i in range(len(lock)):
        lock_map[i+boundary][boundary:size-boundary] = lock[i].copy()

    for i in range(size-boundary):
        for j in range(size-boundary):
            for k in range(4):
                if is_valid(i,j,lock_map,key,lock):
                    print(True)
                    return True
                key = rotate(key)
    print(False)
    return False


def rotate(arr):
    new_arr = [[0]*len(arr) for _ in range(len(arr))]
    for i in range(len(new_arr)):
        for j in range(len(new_arr)):
            new_arr[j][len(new_arr)-1-i] = arr[i][j]
    return new_arr


def is_valid(row, col, _lock_map,_key,_lock):
    new_map = [[0]*len(_lock_map) for _ in range(len(_lock_map))]
    new_map[row:row+len(_key)][col:col+len(_key)] = _key.copy()
    for i in range(len(_key)):
        for j in range(len(_key)):
            new_map[i+row][j+col] = _key[i][j]

    for i in range(len(_lock)):
        for j in range(len(_lock)):
            if _lock_map[i+boundary][j+boundary] == 0 and new_map[i+boundary][j+boundary] == 0:
                return False
            if _lock_map[i+boundary][j+boundary] == 1 and new_map[i+boundary][j+boundary] == 1:
                return False
    return True

