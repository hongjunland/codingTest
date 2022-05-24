function solution(n, words) {
  const record = {};
  record[words[0]] = true;
  let answer = [0,0];
  for(let i = 1 ; i < words.length; i++){
      if(words[i-1].slice(-1) !== words[i][0] || record.hasOwnProperty(words[i])){return [i%n+1,parseInt(i/n)+1];}
      record[words[i]] = true;
  }
  return answer;
}