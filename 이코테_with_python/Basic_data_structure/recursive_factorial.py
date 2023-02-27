# factorial : n! = 1 * 2 * 3 * ... (n-1) * n

def factorial_iterative(n) :
    result = 1
    for i in range(1, n + 1) :
        result *= i
    return result

def factorial_recursive(n) :
    if n <= 1:
        return 1
    # n! = n * (n-1)!를 코드로 작성 
    return n * factorial_recursive(n-1)

print('반복문으로 팩토리얼 구현', factorial_iterative(5))
print('반복문으로 팩토리얼 구현', factorial_recursive(5))