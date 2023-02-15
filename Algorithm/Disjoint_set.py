"""
input:
5
5 6
1 3
2 3
1 2
1 4
3 4
2 4

output:
1 1 1 1 5
1 1 1 1 5
"""
n = int(input())
v, e = map(int, input().split())
parent = []
for i in range(n + 1):
    parent.append(i)


# find root of x
def find(parent, x):
    if parent[x] != x:
        return find(parent, parent[x])
    return x


# union set of parent
def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


for i in range(e):
    a, b = map(int, input().split())
    union(parent, a, b)
# list of roots
for i in range(1, v + 1):
    print(find(parent, i), end=" ")
print()
# list of parent
for i in range(1, v + 1):
    print(parent[i], end=" ")
