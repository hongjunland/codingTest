def solution(play_time, adv_time, logs):
    play_time = encode(play_time)
    adv_time = encode(adv_time)
    boundaries = [0]
    records = [0 for _ in range(play_time)]
    for item in logs:
        start = encode(item[:8])
        end = encode(item[9:])
        boundaries.append(start)
        for i in range(start, end):
            records[i] += 1
    boundaries.sort()
    boundaries = list(filter(lambda x: x <= play_time-adv_time, boundaries))
    max_time = 0
    max_total = 0
    for i, boundary in enumerate(boundaries):
        total = 0
        for j in range(adv_time):
            total += records[boundary+j]
        if max_total < total:
            max_time = boundary
            max_total = total
    return decode(max_time)


def encode(msg):
    return int(msg[0:2])*3600 + int(msg[3:5])*60 + int(msg[6:8])


def decode(num):
    buffer = str(num//3600) if num//3600 >= 10 else "0"+str(num//3600)
    buffer += ":"
    num %= 3600
    buffer = buffer+str(num//60) if num//60 >= 10 else buffer+"0" + str(num//60)
    buffer += ":"
    num %= 60
    buffer = buffer + str(num) if num >= 10 else buffer + "0" + str(num)
    return buffer


if __name__ == '__main__':
    print(solution("02:03:55", "00:14:15", ["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]))
    print(solution("99:59:59", "25:00:00", ["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]))
    print(solution("50:00:00", "50:00:00", ["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]))