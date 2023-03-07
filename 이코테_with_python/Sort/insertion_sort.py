array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)):
    for j in range(i, 0, -1):
        # 현재보다 앞쪽 인덱스 값이 클 경우
        if array[j] < array[j-1]:
            # 한 칸씩 앞쪽 인덱스 방향으로 이동하라
            array[j], array[j-1] = array[j-1], array[j]
        else: 
            # 작은 경우 멈춰라
            break

print(array)

# O(N²)
# 삽입 정렬은 현재 리스트의 데이터가 거의 정렬되어 있는 상태인 경우
# 매우 빠르게 동작
# 최선의 경우 O(N)
# 정렬이 거의 되어 있는 상황에서는 퀵 정렬보다 강력