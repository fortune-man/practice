array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

print(sorted(array))

array.sort()
print(array)

key_value = [('바나나', 2), ('사과', 5), ('당근', 3)]
def setting(data):
    return data[1]
result = sorted(key_value, key = setting)
print(result)