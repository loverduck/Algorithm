#회의실 배정

m_count = int(input())
meeting = []

for i in range(m_count):
    m = list(map(int, input().split()))
    meeting.append(m)

time = 0
cnt = 0

meeting = sorted(meeting, key=lambda x: x[0])
meeting = sorted(meeting, key=lambda x: x[1])

for i in meeting:
    if time <= i[0]:
        cnt += 1
        time = i[1]

print(cnt)
