package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2293 {
    static int N, K;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[101];
        dp = new int[10001];
        for (int i = 1 ; i <= N ; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        dp[0] = 1;
        for(int i = 1; i <= N ; i++){
            for(int j = nums[i] ; i <= K ; j++){
                dp[j] += dp[j-nums[i]];
            }
        }
        System.out.println(dp[K]);
    }
}

