function solution(number, k) {
  const len = number.length - k;
  let result = [number[0]];
  for (let i = 1; i < number.length; i++) {
    while (result.length > 0 && result[result.length - 1] < number[i] && k > 0) {
      result.pop();
      k--;
    }
    result.push(number[i]);
  }
  return result.slice(0, len).join('');
}