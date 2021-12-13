function solution(n, s) {
  let q = parseInt(s / n);
  let r = s % n;
  
  if (q === 0) return [-1];
  
  const array = new Array(n).fill(q);
  return array.map((el, idx) => {
      return array.length - idx <= r ? el + 1 : el;
  })
}