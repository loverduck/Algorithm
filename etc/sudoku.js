const sudoku = function (board) {

  const check = (board, row, col, num) => {
    for (let i = 0; i < 9; i++) {
      let r = Math.floor(row / 3) * 3 + Math.floor(i / 3);
      let c = Math.floor(col / 3) * 3 + i % 3;
      if (board[row][i] === num || board[i][col] === num || board[r][c] === num) {
        return false;
      }
    }
    return true;
  }

  const isSolved = (board) => {
    for (let i = 0; i < 9; i++) {
      for (let j = 0; j < 9; j++) {
        // 빈 값이 아니면 다음으로 넘어가기
        if (board[i][j] !== 0) continue;
        // 빈값이면 1- 9까지 넣어보기
        for (let num = 1; num < 10; num++) {
          // check 함수로 가능하면
          if (check(board, i, j, num)) {
            board[i][j] = num;
            if (isSolved(board)) {
              return true;
            } 
            board[i][j] = 0;
          }
        }
        // 1-9까지 해당하는 값이 없을 경우
        return false;
      }
    }
    return true;
  }

  isSolved(board);
  return board;
};