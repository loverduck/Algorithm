function solution(arr, id) {
  const queue = [];

  for (let i of arr) {
    if (i.id === id) return i;
    if (i.children) {
      queue.push(i.children);
    }
  }

  while (queue.length > 0) {
    const now = queue.shift();
    let result = test2(now, id);
    if (result !== null) return result;
  }

  return null
}