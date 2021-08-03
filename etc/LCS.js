const LCS = function (str1, str2) {
  let count = 0;
  let idx1 = 0;
  const stack = [];

  while (str1.length > idx1) {
    for (let i = 0; i < str2.length; i++) {
      if (str1[idx1] === str2[i]) {
        stack.push(str1[idx1]);
        str2 = str2.slice(i + 1);
        break;
      }
    }
    idx1++;
  }
  return stack.length;
};
  