function solution(places) {

  let answer = places.map((place) => {
    for (let i = 0; i < 5; i++) {
      for (let j = 0; j < 5; j++) {
        let seat = place[i][j];
        if (seat === 'P' && findPersonCnt(i, j, place) > 0) return 0;
        if (seat === 'O' && findPersonCnt(i, j, place) > 1) return 0;
      }
    }
    return 1;
  })

  return answer;
}

function findPersonCnt(x, y, place) {
  const position = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1]
  ];
  let result = 0;

  for (let i of position) {
    const findX = x + i[0], findY = y + i[1];
    if (findX < 0 || findX > 4 || findY < 0 || findY > 4) continue;
    if (place[findX][findY] === 'P') result++;
  }
  return result;
}