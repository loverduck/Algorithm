function solution(array, commands) {
  const answer = commands.map((command) => {
    const [start, end, k] = command;
    const subArr = array.slice(start - 1, end).sort((a, b) => a - b);
    return subArr[k - 1];
  });

  return answer;
}