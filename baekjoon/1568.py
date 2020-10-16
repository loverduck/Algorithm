# 새

n = int(input())
index = 1
second = 0

while n != 0:
    if n < index:
        index = 1
    n -= index
    index += 1
    second += 1

print(second)