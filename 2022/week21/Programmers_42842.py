import math
def solution(brown, yellow):
    answer = 0
    total = brown + yellow
    for height in range(1, int(math.sqrt(total))+1):
        if total % height == 0:
            width = total // height
            if (width + height) * 2 - 4 == brown and (width - 2) * (height - 2) == yellow:
                return [width, height]
    return answer
