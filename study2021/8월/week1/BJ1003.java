import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] memo = new int[100][2];
            StringBuffer sb = new StringBuffer();
            int N = Integer.parseInt(br.readLine());
            fibo(N, memo);
            sb.append(memo[N][0]);
            sb.append(" ");
            sb.append(memo[N][1]);
            System.out.println(sb);
        }
    }

    public static void fibo(int n, int[][] memo) {
        if (n == 0) {
            memo[0][0] = 1;
            memo[0][1] = 0;
            return;
        } else if (n == 1) {
            memo[1][0] = 0;
            memo[1][1] = 1;
            return;
        } else if (n == 2) {
            memo[2][0] = 1;
            memo[2][1] = 1;
            return;
        } else if (memo[n][0] != 0 || memo[n][1] != 0) {
            return;
        } else {
            fibo(n - 2, memo);
            fibo(n - 1, memo);
            memo[n][0] = memo[n - 2][0] + memo[n - 1][0];
            memo[n][1] = memo[n - 2][1] + memo[n - 1][1];
        }
    }
}
