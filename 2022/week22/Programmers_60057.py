def solution(s):
    answer = s
    msg = list(s)
    for i in range(1, len(msg)+1):
        if len(s) % i != 0:
            continue
        current = ''
        buffer = [msg[:i], 1]
        for j in range(i,len(msg),i):
            if ''.join(msg[j:j+i]) == buffer[0]:
                buffer[1] += 1
                continue
            if buffer[1] > 1:
                current += str(buffer[1])
            current += ''.join(buffer[0])
            buffer = [''.join(msg[j:j+i]),1]
        print(current)
        if len(current) < len(answer):
            answer = current
    print(answer)
    return len(answer)