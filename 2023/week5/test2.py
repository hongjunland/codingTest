def findRange(num):
    size = len(str(num))
    max_num = num
    min_num = num
    digit_set = set([])
    for digit in list(str(num)):
        digit_set.add(int(digit))
    for i in range(10):
        for digit in digit_set:
            error_num = str(num).replace(str(digit), str(i))
            error_num = int(error_num)
            if size == len(str(error_num)) and error_num != num and error_num != 0:
                max_num = max(max_num, error_num)
                min_num = min(min_num, error_num)
    print(max_num, min_num)
    return max_num-min_num


if __name__ == '__main__':
    print(findRange(1))