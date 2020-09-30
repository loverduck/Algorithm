n = int(input())
# 왜,, list 안되는거야?
a = set(map(int, input().split()))
m = int(input())
target_list = list(map(int, input().split()))

for i in target_list:
    if i in a:
        print('1')
    else:
        print('0')
