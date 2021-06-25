function power(base, exponent) {
    // let result = 1;
    // while (exponent-- > 0) {
    //   result = result * base % 94906249;
    // }
    // return result;

    if (exponent === 0) return 1;
  
    let half = parseInt(exponent / 2);
    let p = power(base, half);
    let result = p * p % 94906249;

    if (exponent % 2 === 1) return result * base % 94906249;

    return result;
  }