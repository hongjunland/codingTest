def solution(nums):
    result = []
    nums_map = []
    for i in range(len(nums)):
        nums_map.append([i, nums[i]])
    nums_map.sort(key=lambda x: x[1])
    print(nums_map)
    left = 0
    right = len(nums_map)-1
    while left < right:
        if nums_map[left][1] + nums_map[right][1] < 0:
            left += 1
        elif nums_map[left][1] + nums_map[right][1] == 0:
            result.append([nums_map[left][0], nums_map[right][0]])
            right -= 1
        else:
            right -= 1
    left = 0
    right = len(nums_map) - 1
    while left < right:
        if nums_map[left][1] + nums_map[right][1] < 0:
            left += 1
        elif nums_map[left][1] + nums_map[right][1] == 0:
            result.append([nums_map[right][0], nums_map[left][0]])
            left += 1
        else:
            right -= 1
    result = list(map(lambda x: tuple(x), result))
    return result
if __name__ == '__main__':
    # print(solution([1,3,-2,-3,1,-1]))
    print(solution([-5,-5,-3,5]))