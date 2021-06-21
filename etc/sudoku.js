const sudoku = function (board) {
    // TODO: 여기에 코드를 작성합니다.
  
    const check = (row, col, num) => {
      for (let i = 0; i < 9; i++) {
        let r = Math.floor(row / 3) * 3 + Math.floor(i / 3);
        let c = Math.floor(col / 3) * 3 + i % 3;
        if (board[row][i] === num || board[i][col] === num || board[r][c]) {
          return false;
        }
      }
      return true;
    }
  
    const isSolved = (board) => {
      for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
          if (board[i][j] !== 0) continue;
          for (let num = 1; num < 10; num++) {
            if (check(i, j, num)) {
              board[i][j] = num;
              return isSolved(board);
            }
          }
          return false;
        }
      }
      return true;
    }
  
    isSolved(board);
  
    return board;
  };
  
  