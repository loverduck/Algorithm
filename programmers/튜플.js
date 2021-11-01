function solution(s) {
  var answer = [];

  let list = s.replace('{{', '').replace('}}', '').split('},{');
  const tupleList = list.map((el) => el.split(',').map(Number));
  tupleList.sort((a, b) => a.length - b.length);

  tupleList.forEach((tuple) => {
    answer.push(...tuple.filter((el) => !answer.includes(el)))
  })

  return answer;
}