function solution(expression) {
  let answer = 0;

  const priority = [
    ['*', '+', '-'],
    ['*', '-', '+'],
    ['+', '*', '-'],
    ['+', '-', '*'],
    ['-', '*', '+'],
    ['-', '+', '*']
  ]

  for (let p of priority) {
    const number = expression.split(/\D/).map(Number);
    const operator = expression.match(/\D/g);
    for (let opt of p) {
      while (operator.indexOf(opt) !== -1) {
        let idx = operator.indexOf(opt);
        let result = calculator(operator[idx], number[idx], number[idx + 1])
        operator.splice(idx, 1);
        number.splice(idx + 1, 1);
        number[idx] = result;
      }
    }
    answer = Math.max(answer, Math.abs(number[0]));
  }

  return answer;
}

function calculator(operator, num1, num2) {
  if (operator === '*') return num1 * num2;
  if (operator === '+') return num1 + num2;
  if (operator === '-') return num1 - num2;
}