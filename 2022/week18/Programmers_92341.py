import math
def solution(fees, records):
    table = {}
    cars = []
    for record in records:
        time, number, state = record.split()
        if state == 'IN':
            if number not in table:
                table[number] = [get_time(time), -1, 0]
            table[number] = [get_time(time), -1, table[number][2]]
        else:
            table[number][1] = get_time(time)
            table[number][2] += (table[number][1]-table[number][0])
    for number in table:
        start, end, time = table[number]
        if end == -1:
            end = get_time('23:59')
            time += (end-start)
        cars.append([number, time])
    cars.sort(key= lambda x: x[0])
    print(cars)
    answer = list(map(lambda x: get_fee(x[1], fees), cars))
    return answer

def get_fee(time, fees):
    total = fees[1]
    time -= fees[0]
    if time > 0:
        quotient = time/fees[2]
        quotient = math.ceil(quotient)
        total += fees[3] * quotient
    return total
    
def get_time(time):
    hour, mini = time.split(":")
    return int(hour)*60+int(mini)