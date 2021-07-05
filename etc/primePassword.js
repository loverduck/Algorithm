const primePassword = (curPwd, newPwd) => {

  if (curPwd === newPwd) return 0;

  const queue = [[0, curPwd]];
  const visit = new Array(10000).fill(false);
  visit[curPwd] = true;

  while (queue.length > 0) {
    let [count, num] = queue.shift();
    console.log(count, num);
    
    for (let i = 0; i < 4; i++) {
      let numArr = num.toString().split('');
      numArr = numArr.map(el => Number(el));
      for (let j = 0; j < 10; j++) {
        if (numArr[i] !== j) {
          numArr[i] = j;
          let joinNum = Number(numArr.join(''));
          if (joinNum === newPwd) return count + 1;
          if (joinNum > 1000 && isPrime(joinNum) && !visit[joinNum]) {
            visit[joinNum] = true;
            queue.push([count + 1, joinNum]);
          }
        }
        
      }
    }

  }
  return -1;
};

const isPrime = (num) => {
  if (num % 2 === 0 || num === 1) return false;
  let calNum = parseInt(Math.sqrt(num));
  for (let i = 3; i <= calNum; i += 2) {
    if (num % i === 0) {
      return false;
    }
  }
  return true;
}