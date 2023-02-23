# given
divisor, factor = map(int, input().split())
result = 0

# when
while True :
    target = (divisor // factor) * factor
    result += (divisor - target)
    divisor = target

    if divisor < factor:
        break
    result += 1
    divisor //= factor

result += (divisor-1)

# then
print(result)