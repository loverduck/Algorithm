function solution(numbers, hand) {
  let currentLeft = 10;
  let currentRight = 12;
  let result = '';

  for (let number of numbers) {
    if ([1, 4, 7, 10].includes(number)) {
      result += 'L';
      currentLeft = number;
    } else if ([3, 6, 9, 12].includes(number)) {
      result += 'R';
      currentRight = number;
    } else {
      if (number === 0) number = 11;
      let disLeft = distance(number, currentLeft);
      let disRight = distance(number, currentRight);

      if (disLeft === disRight && hand === 'left' || disLeft < disRight) {
        result += 'L';
        currentLeft = number;
      } else {
        result += 'R';
        currentRight = number;
      }
    }
  }

  return result;
}

function distance(a, b) {
  let diff = Math.abs(a - b);
  return parseInt(diff / 3) + (diff % 3);
}