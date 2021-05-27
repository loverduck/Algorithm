n, k = map(int, input().split())
result = 0

while True:
    target = n % k
    result += target
    n -= target

    if n < k:
        break
    n //= k
    result += 1
result += (n - 1)
print(result)
