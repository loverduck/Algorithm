function solution(A, B) {
  A.sort((a, b) => b - a);
  B.sort((a, b) => b - a);
  
  let idx = 0;
  let count = 0;
  
  for (let i = 0; i < A.length; i++) {
      if (A[i] < B[idx]) {
          idx++;
          count++;
      }
  }
  
  return count;
}