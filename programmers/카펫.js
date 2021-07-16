function solution(brown, yellow) {
  let add = (brown - 4) / 2; // M + N 
  for (let i = 1; i <= parseInt(add / 2); i++) {
    if (i * (add - i) === yellow) {
      return [add - i + 2, i + 2]
    };
  }
}