n, l = map(int, input().split())
location = list(map(int, input().split()))

start = 0
cnt = 0

l -= 1

for loc in location:
    if start < loc:
        start = loc + l
        cnt += 1

print(cnt)
