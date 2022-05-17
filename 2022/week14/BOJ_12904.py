def solution():
    S = input()
    T = input()
    while T and T != S:
        if T[-1] == 'B':
            T = T[:-1]
            T = T[::-1]
        elif T[-1] == 'A':
            T = T[:-1]
        else:
            break
    if T == S:
        return 1
    else:
        return 0


if __name__ == '__main__':
    print(solution())
