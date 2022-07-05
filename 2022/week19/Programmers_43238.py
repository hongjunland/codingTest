def solution(n, times):
    left = 1
    right = n * max(times)
    answer = 0
    while left <= right:
        mid = (left + right)//2
        result = 0
        for item in times:
            result += mid // item
        if result >= n:
            right = mid - 1
            answer = mid
        else:
            left = mid + 1
    return answer