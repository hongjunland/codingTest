import heapq


def solution(v, a, b):
    queue = []
    answer = 0
    for item in v:
        heapq.heappush(queue, -item)
    while -queue[-1] >= b and -queue[0] >= a:
        head = -heapq.heappop(queue)
        head -= a
        queue = interval(queue, b)
        heapq.heappush(queue, -head)
        answer += 1
    return answer


def interval(queue: list, consumption: int):
    items = []
    while queue:
        item = -heapq.heappop(queue)
        item -= consumption
        items.append(item)
    for item in items:
        heapq.heappush(queue, -item)
    return queue


if __name__ == '__main__':
    print(solution([4, 5, 5], 2, 1))
    print(solution([4, 4, 3], 2, 1))
