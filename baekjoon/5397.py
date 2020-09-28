# 키로거
test_case = int(input())

for i in range(test_case):
    left_stack = []
    right_stack = []
    data = input()

    for text in data:
        if text == '<':
            if left_stack:
                right_stack.append(left_stack.pop())
        elif text == '>':
            if right_stack:
                left_stack.append(right_stack.pop())
        elif text == '-':
            if left_stack:
                left_stack.pop()
        else:
            left_stack.append(text)

    left_stack.extend(reversed(right_stack))
    print(''.join(left_stack))