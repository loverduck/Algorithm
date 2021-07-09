function solution(numbers, target) {
    let answer = 0;  
    
    const dfs = (sum, count) => {
      if (count === numbers.length) {
        if (sum === target) answer++;
      } else {
        dfs(sum + numbers[count], count + 1);
        dfs(sum - numbers[count], count + 1);
      }
    }
  
    dfs(0, 0);
    return answer;
  }