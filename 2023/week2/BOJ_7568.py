import sys

N = int(sys.stdin.readline())
people = []
for i in range(N):
    people.append(list(map(int, sys.stdin.readline().split())))

result = []
for i in range(N):
    cnt = 1
    for j in range(N):
        if people[i][0] < people[j][0] and people[i][1] < people[j][1]:
            cnt += 1
    result.append(cnt)

print(*result)