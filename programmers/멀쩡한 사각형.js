function solution(w, h) {
  const getGCD = (a, b) => (b > 0 ? getGCD(b, a % b) : a);
  let GCD = getGCD(w, h);
    
  return w * h - ((w + h) - GCD);
}