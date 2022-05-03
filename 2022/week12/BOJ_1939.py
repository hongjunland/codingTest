import sys
from collections import deque

def make(size: int):
    parent = [i for i in range(size)]
    return parent


def find(num: int, parent):
    if num == parent[num]:
        return num
    else:
        return find(parent[num], parent)


def union(target_a: int, target_b: int, parent):
    root_a, root_b = find(target_a, parent), find(target_b, parent)
    if root_a == root_b:
        return False
    else:
        parent[root_a] = root_b
        return True


def bfs(start, target, visited, mat):
    queue = deque([])
    queue.append(start)
    while queue:
        print(queue.popleft())
    return 1

def solution():
    N, M = map(int, sys.stdin.readline().split())
    parent = make(N + 1)
    mat = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
    visited = [[False for _ in range(N + 1)] for _ in range(N + 1)]
    for i in range(M):
        A, B, capacity = map(int, sys.stdin.readline().split())
        mat[A][B] = capacity
        mat[B][A] = capacity
        union(A, B, parent)
    start, target = map(int, sys.stdin.readline().split())
    answer = bfs(start, target, visited, mat)
    print(answer)


if __name__ == '__main__':
    solution()
