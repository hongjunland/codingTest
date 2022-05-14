import sys
days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
INF = sys.maxsize

def solution(masks, dates):
    answer = 0
    plans = []
    for i, date in enumerate(dates):
        if len(date) > 10:
            start, end = date.split("~")
            result = get_date_list(start.split("/"), end.split("/"))
            plans += result
        else:
            year, month, day = date.split("/")
            item = year + month + day
            plans.append(item)
    plans = list(set(plans))
    plans.sort()
    # print(plans)
    items = get_date_list(split_date(plans[0]), split_date(plans[-1]))
    # print(items)
    masks.sort(key=lambda x: x[0])
    # print(masks)
    dp = [INF] * len(items)
    dp[0] = masks[0][0]
    for i in range(1, len(items)):
        y, m, d = map(int, split_date(items[i]))
        if items[i] in plans:
            # idx = plans.index(items[i])
            for mask in masks:
                price, duration = mask
                if i - duration >= 0:
                    dp[i] = min(dp[i], dp[i-duration]+price)
                else:
                    dp[i] = min(dp[i], price)
        else:
            dp[i] = dp[i-1]
    # print(dp)
    return dp[-1]


def split_date(date):
    return [date[:4], date[4:6], date[6:]]


def get_date_list(start, end):
    result = [''.join(start)]
    start = list(map(int, start))
    end = list(map(int, end))
    while not is_expired(start, end):
        y, m, d = start
        y, m, d = aging(y, m, d)
        start = [y, m, d]
        y = str(y)
        m = str(m).zfill(2)
        d = str(d).zfill(2)
        result.append(y + m + d)
    return result


def is_expired(current, end):
    for i in range(3):
        if current[i] != end[i]:
            return False
    return True


def aging(y, m, d):
    d += 1
    if d > days[m - 1]:
        d = 1
        m += 1
    if m > 12:
        m = 1
        y += 1
    return [y, m, d]


if __name__ == '__main__':
    print(solution([[3200, 4], [2300, 2], [1100, 1], [4200, 6]],
                   ["2022/05/02", "2022/05/01", "2022/05/07", "2022/05/05", "2022/05/08", "2022/05/13~2022/05/15",
                    "2022/05/14~2022/05/17", "2022/05/01~2022/05/02", "2022/05/16"]))
    print(solution([[600, 2], [500, 1], [1015, 400]], ["2023/01/01~2023/01/02", "2021/12/31"]))
    print(solution([[3651, 365], [10, 1]], ["2025/01/01~2025/12/31"]))
