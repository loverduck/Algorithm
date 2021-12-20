function solution(n) {
  const memo = [0, 1, 2];
  
  const pibo = (n) => {
      if (memo[n]) return memo[n];
      memo[n] = (pibo(n - 1) + pibo(n - 2)) % 1234567;
      return memo[n];
  }
  
  return pibo(n);
}