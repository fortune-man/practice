array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array) :
    # 리스트가 하나 이하의 원소만을 담고 있는 경우
    if len(array) <= 1:
        return array
    
    # 첫 번째 인덱스를 피벗으로 설정
    pivot = array[0]
    # 나머지 인덱스를 꼬리로 설정
    tail = array[1:]

    # 분할된 왼쪽과 오른쪽 부분
    left_side = [x for x in tail if x <= pivot]
    right_side = [x for x in tail if x > pivot]

    # 분할 후 왼쪽과 오른쪽 부분에서 각각 정렬을 수행한 결과(전체 리스트)를 반환하라
    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

print(quick_sort(array))

# O(NlongN)
# 최악일 경우 O(N²)