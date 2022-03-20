package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17825 {
    static int Result = 0;
    static final int[][] Map = {
            {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},    // 0
            {10,13,16,19,25},  // 1
            {20,22,24,25},     // 2
            {30,28,27,26,25},  // 3
            {25,30,35,40},     // 4
            {40,0},            // 5
    };
    static Ball[] Balls = new Ball[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[10];
        for(int i = 0 ; i < 10 ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0 ; i < 4 ; i++){
            Balls[i] = new Ball();
        }
        dfs(0,0,0);
        System.out.println(Result);
    }

    private static void dfs(int current,int ballIdx, int sum) {
        if(current==10){
            Result = Integer.max(Result,sum);
            return;
        }else{
            for(int i = 0 ; i < 4 ; i++){

            }
        }
    }
    static class Ball{
        int row;
        int col;
        boolean arrived;
        public void update(){
            if(col==Map[row].length-1){
//                for
            }
        }
    }
}
