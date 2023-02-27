# 공백 구분 입력 받기
n, m = map(int, input().split())

# 맵 정보 입력 받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# 특정 노드 방문 후 연결된 모든 노드들도 방문
def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    if graph[x][y] == 0:
        graph[x][y] =1
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y + 1)
        return True
    return False

# 모든 노드에 대해 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1

print(result)