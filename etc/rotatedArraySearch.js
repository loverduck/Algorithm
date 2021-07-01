const rotatedArraySearch = function (rotated, target) {

    let head = 0;
    let tail = rotated.length - 1;
  
    while (head <= tail) {
      let idx = parseInt((head + tail) / 2);
      if (rotated[idx] === target) {
        return idx;
      }
  
      if (rotated[head] < rotated[idx]) { // 왼쪽은 오름차순 정렬
        if (rotated[head] <= target && rotated[idx] >= target) {
          tail = idx - 1;
        } else {
          head = idx + 1;
        }
      } else {
        if (rotated[tail] >= target && rotated[idx] <= target) {
          head = idx + 1;
        } else {
          tail = idx - 1;
        }
      }
    }
  
    return -1;
  };
  