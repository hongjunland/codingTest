package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565 {
    static int N;
    static Wire[] wires;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        wires = new Wire[N];
        dp = new int[N];
        for (int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            wires[i] = new Wire(left,right);
        }
        Arrays.sort(wires);
        for(int i = 0 ; i < N ; i++){
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++){
                if(wires[i].right>wires[j].right){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int answer = 0;
        for(int num : dp){
            answer = Math.max(answer,num);
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(N-answer);
    }

    static class Wire implements Comparable<Wire>{
        int left;
        int right;

        public Wire(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Wire o) {
            return Integer.compare(left,o.left);
        }
    }
}
