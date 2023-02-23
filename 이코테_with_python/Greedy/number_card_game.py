# given : 공백 구분 입력
row, column = map( int, input().split() )

result = 0

# when : 현재 행에서 '가장 작은 수', 가장 작은 수들 중에서 '가장 큰 수' 조회
for i in range(row) : 
    data = list(map(int, input().split()))
    MIN_VALUE = min(data)
    result = max(result, MIN_VALUE)

# then
print(result)


