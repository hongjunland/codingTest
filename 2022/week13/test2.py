def solution(rooms, target):
    table = {}
    for i, item in enumerate(rooms):
        room_number, names = item.split(']')
        room_number = int(room_number[1:])
        names = names.split(',')
        for name in names:
            if name not in table:
                table[name] = []
            table[name].append(room_number)
    table = list(zip(table.keys(), table.values()))
    # print(table)
    for i, item in enumerate(table):
        table[i][1].sort(key=lambda x: abs(x - target))
    # print(table)
    table = list(filter(lambda x: x[1][0] != target, table))
    table.sort(key=lambda x: (len(x[1]), abs(x[1][0]-target), x[0]))
    # print(table)
    answer = list(map(lambda x: x[0], table))
    return answer


if __name__ == '__main__':
    print(solution(["[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"], 403))
    print(solution(["[101]Azad,Guard", "[202]Guard", "[303]Guard,Dzaz"], 202))
    print(solution(["[1234]None,Of,People,Here","[5678]Wow"], 1234))
