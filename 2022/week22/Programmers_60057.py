def solution(s):
    answer = s
    msg = list(s)
    for i in range(1, len(msg)):
        current = ''        # 해당 결과값
        buffer = ['', 1]    # [문자열, 반복횟수]
        right = i           # 인덱스 오른쪽
        for j in range(0, len(msg), i):
            right = i+j
            if buffer[0] == ''.join(msg[j:j+i]):    # 카운팅
                buffer[1] += 1
            else:
                if buffer[1] > 1:
                    current += str(buffer[1])       # 1 초과일 경우 카운터 추가
                current += buffer[0]
                buffer = [''.join(msg[j:j+i]), 1]   # 다른 문자열나올시 초기화
        if buffer[1] > 1:                           # 마지막 buffer넣어주기
            current += str(buffer[1])
        current += buffer[0]
        if right < len(msg)-1:                      # 인덱스 나머지 붙이기
            current += ''.join(msg[right:])
        if len(current) < len(answer):
            answer = current
    return len(answer)