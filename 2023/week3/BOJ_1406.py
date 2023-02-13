"""
input:
abc
9
L
L
L
L
L
P x
L
B
P y

output:
yxabc
"""
import sys
from collections import deque

msg = sys.stdin.readline().strip()
left = list(msg)
right = deque([])
N = int(sys.stdin.readline())
for i in range(N):
    cmd = sys.stdin.readline().split()
    if cmd[0] == 'L' and left:
        right.appendleft(left.pop())
    if cmd[0] == 'D' and right:
        left.append(right.popleft())
    if cmd[0] == 'P':
        left.append(cmd[1])
    if cmd[0] == 'B' and len(left) > 0:
        left.pop()
while right:
    left.append(right.popleft())
print(''.join(left))
