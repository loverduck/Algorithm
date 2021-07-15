const rotateMatrix = function (matrix, k = 1) {
    k = k % 4;
  
    const rotate = function(matrix) {
      if (matrix.length === 0) return [];
      const m = matrix.length;
      const n = matrix[0].length;
      const result = []; 
  
      for (let i = 0; i < n; i++) {
        const row = [];
        for (let j = m - 1; j >= 0; j--) {
          row.push(matrix[j][i]);
        }
        result.push(row);
      }
      return result;
    }
  
    let result = matrix;
    for (let r = 0; r < k; r++) {
      result = rotate(result);
    }
    return result;
  };