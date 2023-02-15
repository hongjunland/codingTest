import sys

N = int(sys.stdin.readline())
sessions = []
for i in range(N):
    start, end = map(int, sys.stdin.readline().split())
    sessions.append([start, end])
sessions.sort()
# 비교군
current = sessions[0]
answer = 1
for i in range(1, N):
    # 서로소 관계일때 비교군 갱신, 회의수 추가
    if current[1] <= sessions[i][0]:
        current = sessions[i]
        answer += 1
        continue
    # 회의 끝나는시간이 더 빠른 것으로 비교군 갱신
    if current[1] >= sessions[i][1]:
        current = sessions[i]

print(answer)