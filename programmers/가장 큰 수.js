function solution(numbers) {
  let answer = '';
  numbers = numbers.map((num) => String(num))
  numbers.sort((a, b) => {
    if (a + b < b + a) {
        return 1;
    }
    if (a + b > b + a) {
        return -1;
    }
  });
  if (numbers[0] === '0') return '0'
  answer = numbers.join(''); 

  return answer;
}