const balancedBrackets = function (str) { 
  if (str.length === 0) return true;
  
  const match = {
    ']': '[',
    '}': '{',
    ')': '('
  }
  
  const stack = [];
  for (let i = 0; i < str.length; i++) {
    console.log(i, str[i]);
    if (str[i] === '[' || str[i] === '{' || str[i] === '(') {
      stack.push(str[i]);
    } else if (str[i] === ']' || str[i] === '}' || str[i] === ')') {
      if (match[str[i]] !== stack[stack.length - 1]) {
        return false;
      }
      stack.pop();
    }
  }
  return stack.length === 0;
};