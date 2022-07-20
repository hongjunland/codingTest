def solution(name):
    answer = 0
    n = len(name)
    min_cnt = n - 1
    for i, ch in enumerate(name):
        answer += get_cnt(ch, 'A')
        next = i + 1
        while next < n and name[next] == 'A':
            next += 1
        min_cnt = min(min_cnt, i + n - next + min(i, n -next))
    answer += min_cnt
    return answer


def get_cnt(current, target):
    return min(abs(ord(current) - ord(target)), min(ord(current), ord(target)) + 26 - max(ord(current), ord(target)))