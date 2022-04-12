def solution(m, musicinfos):
    answer = []
    m = converter(m)
    for i, item in enumerate(musicinfos):
        start, end, title, record = item.split(",")
        interval = (int(end.split(":")[0])-int(start.split(":")[0]))*60 + (int(end.split(":")[1])-int(start.split(":")[1]))
        record = converter(record)
        if interval < len(record):
            record = record[:interval]
        else:
            record = record*(interval//len(record)) + record[:interval%len(record)]
        if m in record:
            answer.append([i, interval, title])
    answer.sort(key=lambda o: (-o[1], o[0]))
    if len(answer) == 0:
        return '(None)'
    return answer[0][2]


def converter(word):
    before = ["A#", "B#", "C#", "D#", "E#", "F#", "G#"]
    after = ["a", "b", "c", "d", "e", "f", "g"]
    for i, item in enumerate(before):
        word = word.replace(item, after[i])
    return word

if __name__ == '__main__':
    print(solution("ABCDEFG", ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
    print(solution("CC#BCC#BCC#BCC#B", ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]))
    print(solution("ABC", ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
    # print(solution("CC#BCC#BCC#", ["03:00,03:08,FOO,CC#B"]))
