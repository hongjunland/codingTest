import math
def solution(n, stations, w):
    answer = 0
    left = 1
    aparts = []
    for station in stations:
        right = station - (w+1)
        if left <= right:
            aparts.append(right-left+1)
        left = station + w + 1
    if left <= n:
        aparts.append(n-left+1)
    for apart in aparts:
        answer += math.ceil(apart/(2*w+1))
    print(left, right, aparts)
    return answer