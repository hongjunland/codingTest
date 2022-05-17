def solution():
    S = input()
    T = input()
    while T and T != S:
        if T[-1] == 'B':
            T = T[:-1]
            T = T[::-1]
        else:
            T = T[:-1]
    if T == S:
        return 1
    return 0


if __name__ == '__main__':
    print(solution())
