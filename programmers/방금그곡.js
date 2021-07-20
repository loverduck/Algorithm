function solution(m, musicinfos) {
  let result = '(None)';
  let resultPlayTime = 0;

  for (let music of musicinfos) {
    let [start, end, title, sound] = music.split(',');
    start = parseInt(start.slice(0, 2)) * 60 + parseInt(start.slice(3));
    end = parseInt(end.slice(0, 2)) * 60 + parseInt(end.slice(3));
    let playTime = end - start;
    let soundArr = sound.match(/\w#?/g);
    let playSound = sound.repeat(parseInt(playTime / soundArr.length)) + soundArr.slice(0, playTime % soundArr.length).join('');
    // (?!#)으로 뒤에 #이 붙지 않은 문자열 선택
    let regex = new RegExp(`${m}(?!#)`);
    if (regex.test(playSound) && resultPlayTime < playTime) {
      result = title;
      resultPlayTime = playTime;
    }
  }

  return result;
}