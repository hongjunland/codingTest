import re

def solution(m, musicinfos):
    musics = []
    answer = []
    m = ''.join(split_score(m))
    for i, item in enumerate(musicinfos):
        musics.append(item.split(","))
    for i, item in enumerate(musics):
        interval = (int(item[1].split(":")[0]) - int(item[0].split(":")[0]))*60 + int(item[1].split(":")[1]) - int(item[0].split(":")[1])
        score = split_score(item[3])

        if interval < len(score):
            score = score[:interval]

        for j in range(len(score)):
            if re.search(m, ''.join(score)):
                answer.append([i, interval, item[2]])
                break
            top = score.pop()
            score.insert(0, top)
        if re.search(''.join(score), m):
            answer.append([i, interval, item[2]])
    if not answer:
        return '(None)'

    answer.sort(key = lambda x: (-x[1], x[0]))

    return answer[0][2]


def split_score(score):

    splited = []
    for i in range(len(score)):
        if score[i] == '#':
            splited[-1] = splited[-1].lower()
        else:
            splited.append(score[i])

    return splited


if __name__ == '__main__':
    print(solution("ABCDEFG",["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
    print(solution("CC#BCC#BCC#BCC#B",["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]))
    print(solution("ABC",["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
