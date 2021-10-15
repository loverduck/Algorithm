function solution(s) {
  s = s.toLowerCase();
  let pCnt = 0, yCnt = 0;
  for (let word of s) {
    if (word === 'p') pCnt++;
    if (word === 'y') yCnt++;
  }

  return pCnt === yCnt;
}