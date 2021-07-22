function solution(name) {
  let count = 0;
  let nameLen = name.length;
  let initName = 'A'.repeat(nameLen); 
  let cursor = 0;

  while (initName !== name) {

    for (let i = 1; i < nameLen; i++) {
      let left = (cursor - i + nameLen) % nameLen;
      let right = (cursor + i) % nameLen;

      if (name[left] !== initName[left]) {
        cursor = left;
        count += i;
        break;
      }
    
      if (name[right] !== initName[right]) {
        cursor = right;
        count += i;
        break;
      }

      let alphabet = name[cursor].charCodeAt(0) - 65;
      count += Math.min(alphabet, Math.abs(nameLen - alphabet));
      initName[cursor] = name[cursor];
    }
  }
  return count;
}