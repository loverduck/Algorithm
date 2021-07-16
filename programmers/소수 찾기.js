function solution(numbers) {
    
  const isPrime = function (num) {
    if (num === 2) return true;
    if (num % 2 === 0 || num === 1) return false;
    let sqrt = parseInt(Math.sqrt(num));
    for (let i = 3; i <= sqrt; i += 2) {
      if (num % i === 0) return false;
    }
    return true;
  }

  const permutation = function (numArr, selectNum) {
    if (selectNum === 1) return numArr.map(el => [el]);
    return numArr.reduce((acc, target, idx, origin) => {
      const rest = [...origin.slice(0, idx), ...origin.slice(idx + 1)];
      const pArr = permutation(rest, selectNum - 1);
      const addArr = pArr.map(el => [target, ...el]);
      acc.push(...addArr);
      return acc;
    }, [])
    
  } 

  const numArr = numbers.split('')
  const result = []
  for (let i = 0; i < numArr.length; i++) {
    const arr = permutation(numArr, i + 1)
    arr.forEach(el => {
      let num = parseInt(el.join(''));
      if (isPrime(num) && !result.includes(num)) result.push(num);
    });
  }

  return result.length;
}