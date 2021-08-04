const uglyNumbers = function (n) {
  // TODO: 여기에 코드를 작성합니다.
  const result = [1];
  let p2 = 0, p3 = 0, p5 = 0;
  while (result.length < n) {
    let num2 = result[p2] * 2, num3 = result[p3] * 3, num5 = result[p5] * 5;
    let minNum = Math.min(num2, num3, num5);
    if (minNum === num2) p2++;
    if (minNum === num3) p3++;
    if (minNum === num5) p5++;
    result.push(minNum);
  }
  return result[n - 1]
};
  