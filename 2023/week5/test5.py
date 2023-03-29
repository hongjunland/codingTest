from collections import deque


def minimumTreePath(n, edges, visitNodes):
    queue = deque([[1, '1']])
    records = {'1': 0}
    answer = 0
    graph = {}
    for i in range(1, n + 1):
        graph[i] = []
    for edge in edges:
        start, end = edge
        graph[start].append(end)
        graph[end].append(start)
    while queue:
        currentNode, currentRecord = queue.popleft()
        if currentNode == n:
            flag = True
            for visitNode in visitNodes:
                if str(visitNode) not in currentRecord:
                    flag = False
                    break
            if flag:
                print(currentRecord)
                return records[currentRecord]
        for nextNode in graph[currentNode]:
            nextRecord = currentRecord + ',' + str(nextNode)
            if nextRecord not in records:
                records[nextRecord] = records[currentRecord] + 1
                queue.append([nextNode, nextRecord])
    return answer


if __name__ == '__main__':
    print(minimumTreePath(5, [[1, 2], [2, 3], [2, 4], [1, 5]], [3, 4]))
