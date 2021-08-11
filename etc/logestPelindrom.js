let longestPalindrome = function (str) {
  if (str.length < 2 || str === str.split('').reverse().join('')) return str.length;

  function expand(l, r) {
    while (l >= 0 && r <= str.length && str[l] === str[r - 1]) {
      l--;
      r++;
    }
    return str.substring(l + 1, r - 1);
  }
  let result = 0;
  for (let i = 0; i < str.length - 1; i++) {
    result = Math.max(result, expand(i,i+1).length, expand(i,i+2).length);
  }
  return result;
};
  