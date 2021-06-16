const bubbleSort = function (arr) {
    for (let i = 0; i < arr.length; i++) {
      let temp;
      for (let j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
      // temp의 값이 undefined이면 모두 정렬되었다는 뜻. 굳이 반복문을 더 돌 필요가 없다.
      if (!temp) { 
        break;
      }
    }
    return arr;
  };