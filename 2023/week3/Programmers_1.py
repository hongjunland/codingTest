def solution(n, computers):
    parent = []
    for i in range(n):
        parent.append(i)

    def find(parent, x):
        if parent[x] != x:
            return find(parent, parent[x])
        return x

    def union(parent, a, b):
        a = find(parent, a)
        b = find(parent, b)
        if a < b:
            parent[b] = a
        else:
            parent[a] = b

    for i in range(n):
        for j in range(i + 1, n):
            if computers[i][j] == 1:
                union(parent, i, j)
    result = {}
    for i in range(n):
        root = find(parent, i)
        result[root] = 1
    # print(result)
    answer = len(result)
    return answer
