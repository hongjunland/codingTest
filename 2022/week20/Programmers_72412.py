def solution(info, query):
    answer = []
    global group  # 그룹목록
    group = {}
    users = [] # 지원자 목록
    for item in info:
        item = item.split()
        item[-1] = int(item[-1])  # 점수 str_to_int
        users.append(item)
    users.sort(key=lambda x: x[-1]) # 이분탐색을 위한 정렬
    init_group()
    for user in users:
        dfs(user, 0, '')  ## '-'가 들어간 목록들도 다 추가

    for q in query:
        q = q.replace(' and', '').split()
        score = int(q[-1])
        q.pop()
        key = ''.join(q)
        index = binary_search(group[key], score)  # 해당 점수 구간찾기
        answer.append(len(group[key])-index)      # 전체 - 구간
        
    return answer
# key 조합
def init_group():
    global group
    lang = ['cpp', 'java', 'python', '-' ]
    job = ['backend', 'frontend', '-']
    career = [ 'junior', 'senior', '-' ]
    food = ['chicken', 'pizza', '-']
    for i in lang:
        for j in job:
            for k in career:
                for l in food:
                    group[i+j+k+l] = []
                    
def dfs(user, index, key):
    global group
    if index == 4:
        group[key].append(user[-1])
    else:
        dfs(user, index+1, key + user[index])
        dfs(user, index+1, key + '-')
        
def binary_search(arr, target):
    left = 0
    right = len(arr)-1
    mid = 0
    while left <= right:
        mid = (left+right) // 2
        if arr[mid] >= target:
            right = mid-1
        else:
            left = mid+1
    return left
            

## 시간초과
# def solution(info, query):
#     answer = [0] * len(query)
#     users = []
#     for i, item in enumerate(info):
#         lang, job, career, food, score = item.split()
#         users.append([lang,job,career,food,int(score)])
#     users.sort(key=lambda x: -x[-1])
#     conditions = []
#     for item in query:
#         condition = item.split(' and ')
#         food, score = condition.pop().split()
#         condition.append(food)
#         condition.append(int(score))
#         conditions.append(condition)
#     for i, condition in enumerate(conditions):
#         result = 0
#         for user in users:
#             flag = False
#             if condition[-1] > user[-1]:
#                 break
#             for j in range(4):
#                 if condition[j] != '-' and condition[j] != user[j]:
#                     flag = True
#                     break
#             if not flag:
#                 result += 1
#         answer[i] = result
#     return answer