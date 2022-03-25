package week8;
import java.util.*;
public class Programmers_92342 {
    public static void main(String[] args) {
        new Solution().solution(5,new int[]{2,1,1,1,0,0,0,0,0,0,0});
//        new Solution().solution(1,new int[]{1,0,0,0,0,0,0,0,0,0,0});
//        new Solution().solution(9,new int[]{0,0,1,2,0,1,1,1,1,1,1});
//        new Solution().solution(10,new int[]{0,0,0,0,0,0,0,0,3,4,3});
    }
    static class Solution {
        int gap;
        int[] answer;
        List<Integer> nums;
        public int[] solution(int n, int[] info) {
            gap = 0;
            nums = new ArrayList<>();
            answer = new int[]{0,0,0,0,0,0,0,0,0,0,0};
            for(long i = 0 ; i < (long) Math.pow(10,11);i++){
                if(isValid(i,n)){
                    String strNum = Long.toString(i);
                    int size = strNum.length();
                    for(int j = 0 ; j < info.length-size; j++){
                        strNum="0"+strNum;
                    }
                    int apeach = 0;
                    int lion = 0;
                    for(int j = 0 ; j < info.length ;j++){
                        if(strNum.charAt(j)==0 && strNum.charAt(j)==info[j]) continue;
                        if(strNum.charAt(j)>info[j]){
                            lion+=(10-j);
                        }else apeach+=(10-j);
                    }
                    if(lion>apeach){
                        gap = Math.max(gap,lion-apeach);
                        for(int j = 0 ; j < info.length ;j++){
                            answer[j] = strNum.charAt(j);
                        }
                        System.out.println(Arrays.toString(answer));
                    }
                }
                i=i*10-1;
            }
            return gap == 0 ? new int[]{-1} : answer;
        }
        public boolean isValid(long num, int size){
            int sum = 0;
            while(num>0){
                sum+=(num%10);
                num/=10;
            }
            if(sum!=size) return false;
            return true;
        }
    }
}
