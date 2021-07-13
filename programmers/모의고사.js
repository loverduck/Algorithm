function solution(answers) {
  const std1 = [1, 2, 3, 4, 5];
  const std2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const std3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
  const count = new Array(3).fill(0);
    
  for (let i = 0; i < answers.length; i++) {
    if (answers[i] === std1[i % std1.length]) count[0]++;
    if (answers[i] === std2[i % std2.length]) count[1]++;
    if (answers[i] === std3[i % std3.length]) count[2]++;
  }
    
  const max = Math.max(...count);

  return count.reduce((acc, el, idx) => {
    if (el === max) acc.push(idx + 1);
    return acc;
  }, []);
}