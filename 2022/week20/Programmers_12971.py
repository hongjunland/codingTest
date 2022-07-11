def solution(sticker):
    answer = 0
    n = len(sticker)
    dp1 = [0] * n
    dp2 = [0] * n
    dp1[0] = sticker[0]
    dp1[1] = max(sticker[0], sticker[1])
    dp2[1] = sticker[1]
    dp2[2] = max(sticker[1],sticker[2])
    for i in range(2,n-1):
        dp1[i] = max(dp1[i-1], dp1[i-2]+ sticker[i])
        dp2[i+1] = max(dp2[i], dp2[i-1] + sticker[i+1])
    print(dp1)     
    print(dp2)
    return max(dp1[-2], dp2[-1])