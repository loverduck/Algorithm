# 문서 검색
document = input()
word = input()

index = 0
result = 0

while len(document) - index >= len(word):
    if document[index:index + len(word)] == word:
        result += 1
        index += len(word)
    else:
        index += 1

print(result)