array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    # 원소가 1개인 경우
    if start >= end:
        # 종료
        return
    # 첫번째 인덱스를 피벗으로 설정하라
    pivot = start
    left = start + 1
    right = end
    while left <= right:
        # 피벗보다 큰 데이터를 찾을 때까지 반복하라
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # 피벗보다 작은 데이터를 찾을 때까지
        while right > start and array[right] >= array[pivot]:
            right -= 1
        # 엇갈린 경우
        if left > right:
            # 작은 데이터와 피벗을 교체하라
            array[right], array[pivot] = array[pivot], array[right]
        # 아니라면
        else:
            # 작은 데이터와 큰 데이터를 교체하라
            array[left], array[right] = array[right], array[left]
    # 분할 후 왼쪽과 오른쪽 각각 정렬을 수행하라
    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)

quick_sort(array, 0, len(array) - 1)

print(array)