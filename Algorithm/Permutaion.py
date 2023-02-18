input_list = [1, 2, 3, 4, 5]
used = [False] * len(input_list)


def perm(arr, n):
    if n == len(input_list):
        print(arr)
        return
    for i in range(len(input_list)):
        if not used[i]:
            used[i] = True
            arr.append(input_list[i])
            perm(arr, n + 1)
            arr.pop()
            used[i] = False


perm([], 0)
