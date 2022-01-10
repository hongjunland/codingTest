package wx.bj1463;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1463 {
    static int[] count;
    static int N;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        count = new int[N+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[N] = 0;
        for(int i = N; i > 0  ; i--){
            if(i%3==0) count[i/3] = Integer.min(count[i/3],count[i]+1);
            if(i%2==0) count[i/2] = Integer.min(count[i/2],count[i]+1);
            if(i>1)  count[i-1] = Integer.min(count[i-1],count[i]+1);
        }
        System.out.println(count[1]);
    }

}
