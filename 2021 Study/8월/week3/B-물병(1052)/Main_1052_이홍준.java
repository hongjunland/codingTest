package com.backjoon._1052;

import java.util.Scanner;

public class Main_1052_이홍준 {
    static int N;
    static int K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int result = 0;
        if(N > K){
            int recent = N;
            for(int i = 0 ; i < K ; i++){
                recent = (int)Math.pow(2,getExp(N));
                N = N-((int)Math.pow(2,getExp(N)));
                if(N==0) break;
            }
            if(N!=0){
                result = recent-N;
            }
        }
        System.out.println(result);
        sc.close();
    }
    public static int getExp(int num){      // 2^k <=n , k의 최댓값
        return (int)(Math.log(num)/Math.log(2));
    }
}
