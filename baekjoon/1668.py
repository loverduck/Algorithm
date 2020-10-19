# 트로피 진열

def ascending(array):
    h = 0
    result = 0
    for i in array:
        if h < i:
            result += 1
            h = i

n = int(input())
arr = []

for _ in range(n):
    arr.append(int(input()))

print(ascending(arr))
arr.reverse()
print(ascending(arr))