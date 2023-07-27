# sys 라이브러리: Python의 시스템 특정 파라미터와 함수들을 제공
# 여기서는 표준 입력을 받기 위해 사용
import sys

def get_inputs():
    """
    사용자 입력을 처리하는 함수
    물품의 개수와 최대 무게를 입력받고, 각 물품의 무게와 가치를 입력받음
    """
    n, k = map(int, sys.stdin.readline().split())
    items = [(0, 0)]
    for _ in range(n):
        w, v = map(int, sys.stdin.readline().split())
        items.append((w, v))
    return n, k, items

def initialize_dp_table(n, k):
    """
    동적 프로그래밍을 위한 테이블을 초기화하는 함수
    """
    dp = [[0] * (k + 1) for _ in range(n + 1)]
    return dp

def compute_maximum_value(n, k, items, dp):
    """
    각 무게 제한에 대한 최대 가치를 계산하는 함수
    """
    for i in range(1, n + 1):
        for j in range(1, k + 1):
            if j >= items[i][0]:  
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1])
            else:  
                dp[i][j] = dp[i - 1][j]
    return dp[n][k]

def main():
    
    n, k, items = get_inputs()
    dp = initialize_dp_table(n, k)
    max_value = compute_maximum_value(n, k, items, dp)
    print(max_value)

if __name__ == "__main__":
    main()
