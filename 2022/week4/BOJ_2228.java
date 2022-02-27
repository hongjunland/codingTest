import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2228 {
    static int N, H;
    static int[] nums;
    static int[][] dp;
    static int Max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new int[N][H];
        nums = new int[N];
        for (int i = 0 ; i < N ; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < H; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum+=nums[j];
                Max = Math.max(Max, sum);
            }
        }
        System.out.println(Max);
    }
}
