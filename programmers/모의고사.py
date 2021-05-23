# 모의고사
def solution(answers):
    
    std1 = [1, 2, 3, 4, 5]
    std2 = [2, 1, 2, 3, 2, 4, 2, 5]
    std3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    count = [0, 0, 0]
    
    for idx, answer in enumerate(answers):
        if answer is std1[idx % len(std1)]:
            count[0] += 1
        if answer is std2[idx % len(std2)]:
            count[1] += 1
        if answer is std3[idx % len(std3)]:
            count[2] += 1
    
    max_score = max(count)
    
    answer = [k + 1 for k in range(3) if count[k] is max_score]
        
    return answer

answers = [1, 3, 2, 4, 2]
print(solution(answers))