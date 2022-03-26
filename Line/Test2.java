import java.util.*;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        new Solution().solution(new String[]{"line in line", "LINE", "in lion"}, 5);
        new Solution().solution(new String[]{"ABcD", "bdbc", "a", "Line neWs"}, 7);
    }
    static private class Solution {
        HashSet<String>[] keys;
        boolean upperCase = false;
        String[] alphabet;
        boolean[] visited;
        String[] Sentences;
        int Max;
        public int solution(String[] sentences, int n) {
            keys = new HashSet[sentences.length];
            Sentences = sentences.clone();
            Max = 0;
            for (int i = 0 ; i < sentences.length ; i++){
                keys[i] = new HashSet<>();
                insertKeys(i,sentences[i]);
            }
            HashSet<String> commonKeys = (HashSet<String>) keys[0].clone(); // 전체집합
            HashSet<String> wholeKeys = (HashSet<String>) keys[0].clone();  // 교집합

            for(int i = 1 ; i < sentences.length ; i++){
                commonKeys.retainAll(keys[i]);
                wholeKeys.addAll(keys[i]);
            }
            if(commonKeys.size()>n) return 0;
            HashSet<String> restKeys = (HashSet<String>) wholeKeys.clone();
            restKeys.removeAll(commonKeys);
            int r = n-commonKeys.size();
            visited = new boolean[restKeys.size()];
            alphabet = restKeys.toArray(new String[restKeys.size()]);
            combination((HashSet<String>) commonKeys.clone(),0, restKeys.size(),r);
            return Max;
        }
        public void combination(HashSet<String> selected, int start, int n, int r){
            if(r==0){
                int sum = 0;
                for(int i = 0 ; i < keys.length; i++){
                    if(isValid(selected, Sentences[i])){
                        sum+=getScore(i, Sentences[i]);
                    }
                }
                Max = Math.max(Max, sum);
            }
            else{
                for(int i = start ; i < n ; i++){
                    visited[i] = true;
                    selected.add(alphabet[i]);
                    combination(selected, i+1, n, r-1);
                    visited[i] = false;
                    selected.remove(alphabet[i]);
                }
            }
        }
        public boolean isValid(HashSet<String> selected, String msg){
            boolean flag = false;
            if(selected.contains("shift")) flag = true;
            for(int i = 0 ; i < msg.length() ; i++){
                String str = Character.toString(msg.charAt(i));
                if(msg.charAt(i)==' ') continue;
                if(flag){
                    if(msg.charAt(i) < 97){
                        if(!selected.contains(str.toLowerCase())){
                            return false;
                        }
                    }else {
                        if(!selected.contains(str)){
                            return false;
                        }
                    }
                }else{
                    if(!selected.contains(str)){
                        return false;
                    }
                }
            }
            return true;
        }
        public int getScore(int idx, String msg){
            int sum = msg.length();
            for(int i = 0 ; i < msg.length(); i++){
                if(Pattern.matches("^[A-Z]*$",Character.toString(msg.charAt(i)))){
                    upperCase = true;
                    sum++;
                }
            }
            return sum;
        }
        public void insertKeys(int idx,String msg){
            for(int i = 0 ; i < msg.length(); i++){
                if(Pattern.matches("^[A-Z]*$",Character.toString(msg.charAt(i)))){
                    upperCase = true;
                    keys[idx].add(Character.toString(Character.toLowerCase(msg.charAt(i))));
                    keys[idx].add("shift");
                }else{
                    if(msg.charAt(i)!=' ')
                        keys[idx].add(Character.toString(msg.charAt(i)));
                }
            }
        }
    }
}
