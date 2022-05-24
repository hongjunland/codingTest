function solution(s) {
  let answer = '';
  const word = {
      zero: 0,
      one: 1,
      two: 2,
      three: 3,
      four: 4,
      five: 5,
      six: 6,
      seven: 7,
      eight: 8,
      nine: 9
  }
  let buffer = '';
  for(let i = 0 ; i < s.length; i++){
      buffer += s[i];
      if(word.hasOwnProperty(buffer)){
          answer+=word[buffer];
          buffer='';
      }else if(!isNaN(buffer)){
          answer+=buffer;
          buffer='';
      }
  }
  return parseInt(answer);
}