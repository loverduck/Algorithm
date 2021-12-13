function solution(stones, k) {
  let count = -1;
  let maxDist = 1;
  while (maxDist <= k) {
      count++;
      let dist = 1;
      for (let i = 0; i < stones.length; i++) {
          if (stones[i] !== 0) {
              maxDist = Math.max(maxDist, dist);
              dist = 1;
              stones[i]--;
              continue;
          }
          dist++;
      }
  }
  
  return count;
}