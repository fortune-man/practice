array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_index = i
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
            # swap, temp 임시 변수 사용과 동일한 원리, 두 변수 할당 위치 변경
    array[i], array[min_index] = array[min_index], array[i]

print(array)


# n + (n-1) + (n-2) + ... + 2
# n x (n + 1) / 2
# (n² + n) / 2
# O(N²)