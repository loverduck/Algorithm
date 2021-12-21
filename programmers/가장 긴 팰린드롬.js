function solution(s) {
  if (s.length < 2 || s === s.split('').reverse().join('')) return s.length;
  
  const expand = (l, r) => {
      while (l >= 0 && r <= s.length && s[l] === s[r - 1]) {
        l--;
        r++;
      }
      return s.substring(l + 1, r - 1);
  }
  
  let result = 0;
  for (let i = 0; i < s.length - 1; i++) {
      result = Math.max(result, expand(i, i + 1).length, expand(i, i + 2).length);
  }
  return result;
}

