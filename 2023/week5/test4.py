def longestChain(words):
    words.sort(key=len)
    dp = {}
    for word in words:
        max_size = 0
        for cursor in range(len(word)):
            temp = word[:cursor] + word[cursor+1:]
            if temp in dp:
                max_size = max(max_size, dp[temp] + 1)
            else:
                max_size = max(max_size, 1)
        dp[word] = max_size
    return max(dp.values())

if __name__ == '__main__':
    print(longestChain(['a', 'b', 'ba', 'bca', 'bda', 'bdca']))
    print(longestChain(['a', 'ab', 'ba', 'abca', 'bda', 'bdca']))