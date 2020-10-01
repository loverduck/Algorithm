# 친구 네트워크
def find(x):
    if x == parent[x]:
        return x
    else:
        p = find(parent[x])
        parent[x] = p
        return parent[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x != y :
        parent[y] = x
        number[x] += number[y]

test_case = int(input())

for i in range(test_case):
    parent = dict()
    number = dict()
    F = int(input())
    
    for j in range(F):
        x, y = input().split()
        
        if x not in parent:
            parent[x] = x
            number[x] = 1
        if y not in parent:
            parent[y] = y
            number[y] = 1
        
        union(x, y)

        print(number[find(x)])