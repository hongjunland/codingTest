import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2228 {
    static int N,M;
    static int[] nums;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        dp = new int[N+1][M];
        for (int i = 1 ; i <= N ; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        dp[1][0] = nums[1];
        for(int i = 2 ; i <= N; i++){
        }

    }
}
