def solution(atmos):
    answer = 0
    mask_duration = -1
    for i, item in enumerate(atmos):
        dust, ul_dust = item
        mask_duration -= 1
        if get_dust_state(dust) >= 2 or get_ul_dust_state(ul_dust) >= 2:
            if mask_duration < 0:
                mask_duration = 2
                answer += 1
        if get_dust_state(dust) > 2 and get_ul_dust_state(ul_dust) > 2:
            mask_duration = 0
        print(i + 1, mask_duration, answer)
    return answer


def get_dust_state(value: int):
    if value <= 30:
        return 0
    if 31 <= value <= 80:
        return 1
    if 81 <= value <= 150:
        return 2
    else:
        return 3


def get_ul_dust_state(value: int):
    if value <= 15:
        return 0
    if 16 <= value <= 35:
        return 1
    if 36 <= value <= 75:
        return 2
    else:
        return 3


if __name__ == '__main__':
    # print(solution([[80, 35], [70, 38], [100, 41], [75, 30], [160, 80], [77, 29], [181, 68], [151, 76]]))
    # print(solution([[140, 90], [177, 75], [95, 45], [71, 31], [150, 30], [80, 35], [72, 33], [166, 81], [151, 75]]))
    print(solution([[30, 15], [80, 35]]))
