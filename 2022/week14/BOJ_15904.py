import sys


def solution():
    msg = list(sys.stdin.readline())
    msg = filter(lambda x: x == 'U' or x == 'C' or x == 'P', msg)
    target = 'UCPC'
    cursor = 0
    for item in msg:
        if target[cursor]==item:
            cursor+=1
        if cursor > 3:
            return 'I love UCPC'
    return 'I hate UCPC'


if __name__ == '__main__':
    print(solution())
