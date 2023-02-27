from collections import deque

# n, m 공백 구분 입력받기
n, m = map(int, input().split())

# 맵 정보 입력 받기 (2차원 리스트)
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# 이동 방향 정의 (상, 하, 좌, 우)
direction_x = [-1, 1, 0, 0]
directon_y = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        # 현재 노드에서 네 방향 위치 확인
        for i in range(4):
            nx = x + direction_x[i]
            ny = y + directon_y[i]
            # 미로 찾기 공간을 벗어난 경우
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                # 무시하라
                continue
            # 벽인 경우
            if graph[nx][ny] == 0:
                # 무시하라
                continue
            # 해당 노드를 처음 방문하는 경우
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                # 최단 거리를 기록하라
                queue.append((nx, ny))
    # 가장 오른쪽 아래까지의 최단 거리
    return graph[n-1][m-1]

print(bfs(0, 0))