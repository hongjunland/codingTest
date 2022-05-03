function solution(S) {
  let flag = false;
  let count = Math.floor(Math.log2(S.length));
  while (!flag && count > 0){
    count--;
  }
}

// console.log(solution('world'));
// console.log(solution('dddd'));
// console.log(solution('cycle'));
// console.log(solution('abba'));
console.log(solution('abacdec'));
