def maxLength(a, k):
    size = len(a)
    answer = 0
    left = 0
    total = 0
    for right in range(size):
        total += a[right]
        while total > k:
            total -= a[left]
            left += 1
        answer = max(answer, right - left + 1)

    return answer


if __name__ == '__main__':
    print(maxLength([1, 2, 3], 4))
    print(maxLength([1, 2, 3], 6))
