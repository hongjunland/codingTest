def solution(logs):
    answer = dict()
    persons = dict()
    for item in logs:
        person_no, pro_no, score = item.split(" ")
        if not persons.get(person_no):
            persons[person_no] = [0, dict()]
        if not persons[person_no][1].get(pro_no):
            persons[person_no][0] += 1
        persons[person_no][1][pro_no] = score
    for person1 in persons.keys():
        for person2 in persons.keys():
            if person1 == person2:
                continue
            if check(persons[person1], persons[person2]):
                answer[person1] = True
                answer[person2] = True
    print(persons)
    if not answer.keys():
        return ['None']
    answer = list(answer.keys())
    answer.sort()
    return answer


def check(p1, p2):
    if p1[0] < 5 or p2[0] < 5 or p1[0] != p2[0]:
        return False
    count = 0
    for pro_no1 in p1[1].keys():
        if p2[1].get(pro_no1) and p1[1][pro_no1] == p2[1][pro_no1]:
            count += 1
        else:
            return False
    return True


if __name__ == '__main__':
    # print(solution(
    #     ["0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90",
    #      "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"]))
    # print(solution(["1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"]))
    print(solution(["1901 10 50", "1909 10 50"]))
    # print(solution(["0001 1 0", "0001 2 0", "0001 3 0", "0001 4 0", "0001 5 0", "0456 1 0", "0456 2 0", "0456 3 0", "0456 4 0", "0456 5 0"]))
