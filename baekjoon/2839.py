N = int(input())
box = N // 5
M = N % 5

while box >= 0:
    if M % 3 == 0:
        box += M // 3
        break
    box -= 1
    M += 5

print(box)