def solution(enroll, referral, seller, amount):
    answer = [0 for _ in range(len(enroll))]
    graph = {}
    for i in range(len(referral)):
        graph[enroll[i]] = [i, referral[i]]   ## [회원 인덱스, 회원 이름]

    for i, item in enumerate(seller):
        income = amount[i] * 90
        commision = amount[i] * 10
        idx = graph[item][0]
        answer[idx] += income
        next = graph[item][1]
        while next != '-' and income>0:     ## 추천인이 없거나 수입이 0일경우 종료
            income = commision-commision//10 
            commision = commision//10
            idx = graph[next][0]
            answer[idx] += income
            next = graph[next][1]
        
    return answer