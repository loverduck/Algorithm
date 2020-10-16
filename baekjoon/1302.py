# 베스트셀러

n = int(input())

for _ in range(n):
    book = input()
    if book in hash:
        hash[book] += 1
    else:
        hash[book] = 1

target = max(hash.values())
arr = []

for book, number in hash.items():
    if number == target:
        arr.append(book)

print(sorted(arr)[0])