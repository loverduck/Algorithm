function solution(price, money, count) {
  let sum = 0, incPrice = 0;

  for (let i = 1; i <= count; i++) {
    incPrice = price * i;
    sum += incPrice;
  }

  if (money >= sum) return 0;

  return sum - money;
}