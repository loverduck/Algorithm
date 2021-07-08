const LPS = function (str) {
  let count = 0

  for (let i = 0; i <= str.length / 2; i++) {
    let prefix = str.slice(0, i);
    let suffix = str.slice(str.length - i);
    
    if (prefix === suffix) {
      count = i;
    }
  };

  return count;
};