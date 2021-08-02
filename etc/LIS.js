const LIS = function (arr) {
//TODO: 여기에 코드를 작성합니다.
  let count = 0;
  const stack = [];
  for (let i = 0; i < arr.length; i++) {
    if (stack.length === 0 || stack[stack.length - 1] < arr[i]) {
    stack.push(arr[i]);
    } else if (stack[stack.length - 1] > arr[i] && stack[stack.length - 2] < arr[i] || !stack[stack.length - 2]) {
      stack.splice(-1, 1, arr[i]);
    }
  }
  return stack.length;
};