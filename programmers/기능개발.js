function solution(progresses, speeds) {
  const result = [];

  progresses = progresses.map((el, idx) => Math.ceil((100 - el) / speeds[idx]))

  while (progresses.length > 0) {
    let idx = progresses.findIndex(el => el > progresses[0]);
    if (idx === -1) {
      result.push(progresses.length);
      break;
    };
    result.push(idx);
    progresses = progresses.slice(idx);
  }

  return result;
}