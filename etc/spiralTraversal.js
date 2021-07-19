const spiralTraversal = function (matrix) {
  const left = [0, -1];
  const right = [0, 1];
  const up = [-1, 0];
  const down = [1, 0];
  const move = [right, down, left, up];

  let mLen = matrix.length;
  let nLen = matrix[0].length;
  const strLen = nLen * mLen;
  let result = '';
  let direction = 0;
  let curRow = 0, curCol = -1;

  while (result.length < strLen) {
    let [moveRow, moveCol] = move[direction % 4];
    curRow += moveRow;
    curCol += moveCol;

    if (curRow < 0 || curRow >= mLen || curCol < 0 || curCol >= nLen || matrix[curRow][curCol] === false) {
      direction++;
      curRow -= moveRow;
      curCol -= moveCol;
    } else {
      result += matrix[curRow][curCol];
      matrix[curRow][curCol] = false;
    }
  }
  return result;
};