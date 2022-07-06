def solution(record):
    answer = []
    user = {}
    for item in record:
        item = item.split()
        if not item[0] == 'Leave':
            user[item[1]] = item[2]
            
    for item in record:
        state = item.split()[0]
        if state == 'Change':
            continue
        result = user[item.split()[1]]
        if state == 'Enter':
            result += '님이 들어왔습니다.'
        elif state == 'Leave':
            result += '님이 나갔습니다.'
        answer.append(result)
    return answer