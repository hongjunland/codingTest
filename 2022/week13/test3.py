def solution(line):
    answer = []
    # size 2 x 10
    mat = [['1', '2', '3', '4', '5', '6', '7', '8', '9', '0'],
           ['Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P']]
    left = [[1, 0], 0]
    right = [[1, 9], 1]
    for item in list(line):
        result = [left, right]
        target = get_location(item, mat)
        result.sort(key=lambda x: (get_distance(x[0], target), get_horizontal_distance(x[0], target)))
        if get_distance(left[0], target) == get_distance(right[0], target) and get_horizontal_distance(left[0], target) == get_horizontal_distance(
                right, target):
            location = get_location(target, mat)
            if location[1] <= 4:
                result = [left, right]
            else:
                result = [right, left]
        if result[0][1] == 0:
            left = [target, 0]
        else:
            right = [target, 1]
        answer.append(result[0][1])

    return answer


def get_distance(arr1, arr2):
    return abs(arr1[0] - arr2[0]) + abs(arr1[1] - arr2[1])


def get_horizontal_distance(arr1, arr2):
    return abs(arr1[1] - arr2[1])


def get_location(target, mat):
    for i in range(2):
        for j in range(10):
            if target == mat[i][j]:
                return [i, j]


if __name__ == '__main__':
    print(solution("Q4OYPI"))
    # print(solution("RYI76"))
    # print(solution("64E2"))
