import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
mat = [[] for _ in range(N + 1)]


def bfs(start, target, weight):
    queue = deque()
    visited = [False] * (N + 1)
    visited[start] = True
    queue.append(start)
    while queue:
        current = queue.popleft()
        if current == target:
            return True
        for item in mat[current]:
            if not visited[item[0]] and item[1] >= weight:
                visited[item[0]] = True
                queue.append(item[0])
    return False


def solution():
    answer = 0
    for i in range(M):
        A, B, capacity = map(int, sys.stdin.readline().split())
        mat[A].append([B, capacity])
        mat[B].append([A, capacity])
    start, target = map(int, sys.stdin.readline().split())
    low, high = 1, 1000000000
    while low <= high:
        mid = (low + high) // 2
        if bfs(start, target, mid):
            answer = mid
            low = mid + 1
        else:
            high = mid - 1

    return answer


if __name__ == '__main__':
    print(solution())
