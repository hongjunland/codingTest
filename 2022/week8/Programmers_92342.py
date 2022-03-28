global gap_max

def solution(n, info):
    answer = [-1]
    bit = (1 << 12)-1
    gap_max = 0
    for i in range(bit,0):
        if is_valid(n,info,bit):
            return get_result(info, bit)
    return answer

def get_result(info, bit):
    arr = [0]*len(info)
    for i in range(len(info)):
        if bit & (1 << i) == (1 << i):
            arr[i] = info[i]+1


def is_valid(n, info, bit):
    lion = 0
    apeach = 0
    for i in range(len(info)):
        if bit & (1 << i) == (1 << i):
            n -= (info[i]+1)
            lion+=i
            if n < 0: return False
        elif bit & (1 << i):
            if info[i]!=0:
                apeach+=i

    gap_max = max([num,lion-apeach])
    return True


print(solution([2,1,1,1,0,0,0,0,0,0,0],[0,2,2,0,1,0,0,0,0,0,0]))