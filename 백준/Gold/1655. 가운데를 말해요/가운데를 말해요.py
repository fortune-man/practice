import heapq
import sys

def solve():
    # 두 개의 힙을 초기화합니다.
    left, right = [], [] # left는 최대 힙, right는 최소 힙
    n = int(sys.stdin.readline())
    
    for _ in range(n):
        num = int(sys.stdin.readline())
        
        # left의 길이와 right의 길이가 같다면, left에 삽입
        if len(left) == len(right):
            heapq.heappush(left, (-num, num))
        else:
            heapq.heappush(right, (num, num))
        
        # left의 최대 원소가 right의 최소 원소보다 크다면, 두 원소 교체
        if right and left[0][1] > right[0][1]:
            max_val = heapq.heappop(left)[1]
            min_val = heapq.heappop(right)[1]
            heapq.heappush(left, (-min_val, min_val))
            heapq.heappush(right, (max_val, max_val))
        
        # 중간값 출력
        print(left[0][1])

solve()
