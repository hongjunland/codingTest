import sys

nums = []
for i in range(5):
    nums.append(int(sys.stdin.readline()))

print(sum(nums)//5)
print(sorted(nums)[2])