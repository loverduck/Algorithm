function solution(s) {
  let answer = 1000;
  const len = s.length;
  // TestCase 5: s의 길이가 1일 때, maxSlice = len / 2 = 0이 되므로 예외 설정
  const maxSlice = parseInt(len / 2) || 1;

// 압축 단위를 1부터 s.length / 2까지 늘려가며 반복
  for (let sliceNum = 1; sliceNum <= maxSlice; sliceNum++) {
    let result = '';
    let count = 1;
    
    for (let i = 0; i < len; i += sliceNum) {
    // 문자열을 제일 앞부터 압축단위만큼 잘라 뒤의 문자열과 비교
      let str = s.substr(i, sliceNum);
      let nextStr = s.substr(i + sliceNum, sliceNum);
        
      if (str !== nextStr) { // 동일하지 않은 문자열이면
        // 반복횟수가 여러번이면 반복숫자 + 문자열
        // 반복횟수가 한번이면 문자열만 저장
        result = (count === 1) ? result + str : result + count + str;
        count = 1;
      } else { // 문자열이 동일한 경우 반복횟수 증가
        count++;
      }
    }
    // answer에는 압축 후 가장 길이가 짧았을 때를 저장
    answer = Math.min(answer, result.length)
  }
  return answer;
}