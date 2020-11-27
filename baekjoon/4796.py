# 캠핑
l, p, v = map(int, input().split())

result =  (v // p) * l
day = v % p

if day < l:
    result += day
else:
    result += l

print(result)