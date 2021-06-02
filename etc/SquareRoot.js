function computeSquareRoot(num) {
    let x = 1;
    let eps = 0.0001
    while (x ** 2 !== num) {
      if (Math.abs(num - x ** 2) < eps)
        break;
      x = (x + num / x) / 2;
    }
    return parseFloat(x.toFixed(2))
  }  