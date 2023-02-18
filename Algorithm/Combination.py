nums = [1, 2, 3, 4, 5]

answer_list = []


def combination(n, r, arr):
    if n == len(nums):
        if r == len(arr):
            new_arr = arr.copy()
            answer_list.append(new_arr)
        return
    arr.append(nums[n])
    combination(n + 1, r, arr)
    arr.pop()
    combination(n + 1, r, arr)


combination(0, 2, [])
print(answer_list)
