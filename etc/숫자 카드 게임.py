n, m = map(int, input().split())
result = 0
for i in range(n):
    min_card = min(list(map(int, input().split())))
    result = max(min_card, result)

print(result)