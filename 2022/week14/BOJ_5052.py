import sys
import re


def solution():
    test_case = int(sys.stdin.readline())
    result = []
    for i in range(test_case):
        size = int(sys.stdin.readline())
        book = []
        for j in range(size):
            book.append(int(sys.stdin.readline()))
        book.sort()
        if is_consistent(book):
            result.append('YES')
        else:
            result.append('NO')

    for item in result:
        print(item)


def is_consistent(book: list):
    for i in range(len(book)):
        phone_a = str(book[i])
        size = len(phone_a)
        for j in range(i+1, len(book)):
            phone_b = str(book[j])
            if phone_a == phone_b[:size]:
                # print(phone_a, phone_b)
                return False
    return True


if __name__ == '__main__':
    solution()
