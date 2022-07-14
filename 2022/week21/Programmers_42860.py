def solution(name):
    size = len(name)
    startName = list('A'*size)
    currrent = 0
    cnt = 0
    while ''.join(startName)!=name:
        if startName[currrent] != name[currrent]:
            cnt += count_diff(startName[currrent], name[currrent])
            startName[currrent] = name[currrent]
        else:
            left = 0
            right = 0
            while True:
                left +=1
                if startName[(currrent-left)%size] != name[(currrent-left)%size]:
                    break
            while True:
                right +=1
                if startName[(currrent+right)%size] != name[(currrent+right)%size]:
                    break
            if left>=right:
                currrent = (currrent+right)%size
                cnt+=right
            else:
                currrent = (currrent - left) % size
                cnt += left
    return cnt
def count_diff(num1,num2):
    maxNum = max(ord(num1), ord(num2))
    minNum = min(ord(num1), ord(num2))
    return min(maxNum - minNum, 26 - maxNum + minNum)