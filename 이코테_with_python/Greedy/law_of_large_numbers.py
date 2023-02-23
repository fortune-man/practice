# given : 공백 구분 입력, 정렬
n, m, k = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
first = data[n-1]
second = data[n-2]

# when : 가장 큰 수가 더해지는 횟수 정의
count = int(m / (k+1)) * k
count += m % (k+1)

# then
result = 0

result += (count) * first
result += (m - count) * second

print(result)