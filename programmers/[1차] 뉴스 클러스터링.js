function solution(str1, str2) {
  str1 = str1.toLowerCase().replace(/[^a-z]/g, ' ');
  str2 = str2.toLowerCase().replace(/[^a-z]/g, ' ');

  let set1 = [];
  let set2 = [];
  const intersection = [];
  const union = [];

  for (let i = 1; i < str1.length; i++) {
    if (str1[i - 1] !== ' ' && str1[i] !== ' ') {
      set1.push(str1.slice(i - 1, i + 1));
    }
  }

  for (let i = 1; i < str2.length; i++) {
    if (str2[i - 1] !== ' ' && str2[i] !== ' ') {
      set2.push(str2.slice(i - 1, i + 1));
    }
  }

  set1 = set1.filter((el) => {
    let idx = set2.indexOf(el);
    if (idx !== -1) {
      intersection.push(...set2.splice(idx, 1));
      return false;
    }
    return true;
  })

  const interLen = intersection.length;
  const unionLen = set1.length + set2.length + interLen;

  return unionLen !== 0 ? parseInt(interLen / unionLen * 65536) : 65536;
}