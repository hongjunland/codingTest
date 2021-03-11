# 경로 횟수 찾기 문제

# N, M = map(int, input().split())
N, M = 4 ,4
# row, col, dirc = map(int, input().split())
row, col, dirc = 1, 1 , 0
input_data = [[1,1,1,1],[1,0,0,1],[1,1,0,1],[1,1,1,1]]
# for i in range(N):
#     input_data.append(list(map(int, input().split())))
history = [[row,col]]
steps = [(-1, 0), (0, 1), (1, 0), (0, -1)]
result = 0
while True:
    upStair = True
    for i in range(4):
        dirc = (dirc - 1) % 4
        step = [steps[dirc][0],steps[dirc][1]]
        next_row = row + step[0]
        next_col = col + step[1]
        if 1 <= next_row < N and 1 <= next_col < M and input_data[next_row][next_col] == 0 and [next_row, next_col] not in history:
            row = next_row
            col = next_col
            history.append([row, col])
            result += 1
            upStair = False
            break
    if upStair:
        next_row = row + steps[dirc][0] * (-1)
        next_col = col + steps[dirc][-1] * (-1)
        if input_data[next_row][next_col] == 1:
            break
        row = next_row
        col = next_col
        history.append([row,col])
        result+=1






print(history)
print(result)





