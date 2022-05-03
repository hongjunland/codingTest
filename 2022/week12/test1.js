function solution(N, K) {
  let current = 0;
  while (K > 0 && N < 999 && current < 3) {
    let num = N.toString().slice(current, current + 1);
    if (num >= 9) {
      current++;
      continue;
    }
    N += 10 ** (2 - current);
    K--;
  }
  return N;
}
console.log(solution(512, 10));
console.log(solution(191,4));
console.log(solution(285,20));
