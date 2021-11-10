function solution(n, arr1, arr2) {
  const answer = [];

  for (let i = 0; i < n; i++) {
    let num = arr1[i] | arr2[i];
    num = num.toString(2).padStart(n, '0').replace(/1/g, '#').replace(/0/g, ' ');
    answer.push(num);
  }

  return answer;
}