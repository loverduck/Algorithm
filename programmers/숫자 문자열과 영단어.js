function solution(s) {
  const numList = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];

  for (let i = 0; i < 10; i++) {
    let regex = new RegExp(numList[i], "g");
    s = s.replace(regex, i);
  }
  return +s;
}