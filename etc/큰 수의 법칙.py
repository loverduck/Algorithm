n, m, k = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
first_max = data[-1]
second_max = data[-2]

count = int(m / (k + 1)) * k + m % (k + 1)
result = count * first_max + (m - count) * second_max 

