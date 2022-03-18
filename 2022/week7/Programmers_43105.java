package week7;

import java.util.Arrays;

public class Programmers_43105 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
    static private class Solution {
        int[][] dp;
        public int solution(int[][] triangle) {
            dp = new int[triangle.length][];
            for (int i = 0 ; i < triangle.length; i++){
                dp[i] = new int[triangle[i].length];
            }
            dp[triangle.length-1] = triangle[triangle.length-1].clone();
            for(int i = triangle.length-2 ; i >= 0 ; i--){  // 상향식으로 계산
                for (int j = 0 ; j <= i; j++){
                    dp[i][j] = Math.max(dp[i+1][j]+triangle[i][j],dp[i+1][j+1]+triangle[i][j]);
                }
            }
            int answer = dp[0][0];
            return answer;
        }
    }

}