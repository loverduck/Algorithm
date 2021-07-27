function solution(n, words) {
  let answer = [0, 0];
  let exist = {};
  let prevLetter = words[0].slice(-1);
  exist[words[0]] = true;

  for (let i = 1; i < words.length; i++) {
    if (prevLetter !== words[i][0] || exist[words[i]]) {
      answer = [i % n + 1, parseInt(i / n) + 1];
      break;
    }
    prevLetter = words[i].slice(-1);
    exist[words[i]] = true;
  }
  return answer;
}