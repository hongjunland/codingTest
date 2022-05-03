function solution(S) {
  let answer = S[0];
  let currentChar = S[0];
  let count = 1;
  for(let i = 1; i < S.length; i++){
    if(currentChar == S[i]){
      count++;
      if(count>2) continue
    }
    else{
      currentChar = S[i];
      count = 1;
    }
    answer += currentChar;
  }
  return answer;
}

console.log(solution('eedaaad'));
console.log(solution('xxxtxxx'));
console.log(solution('uuuuxaaaaxuuu'));