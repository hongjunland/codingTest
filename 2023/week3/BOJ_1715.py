import sys
import heapq

N = int(sys.stdin.readline())
cards = []
for i in range(N):
    heapq.heappush(cards, int(sys.stdin.readline()))
total = 0
while len(cards) > 1:
    element1 = heapq.heappop(cards)
    element2 = heapq.heappop(cards)
    total += element1 + element2
    heapq.heappush(cards, element1 + element2)
print(total)
