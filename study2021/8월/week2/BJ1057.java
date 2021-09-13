package com.backjoon._1057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1057_이홍준 {
    static int Count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int A = Integer.parseInt(line[1]);
        int B = Integer.parseInt(line[2]);
        boolean flag = false;
        while (N>0){
//            System.out.println(A +"," + B);
            if(isConfront(A,B)){
                flag = true;
                break;
            }
            A = (A+1)/2;
            B = (B+1)/2;
            N/=2;
            Count++;
        }
        if(!flag) Count = -1;
        sb.append(Count);
        System.out.println(sb);
    }
    public static boolean isConfront(int a , int b){
        if((a+1)/2 == (b+1)/2) return true;
        return false;
    }
}
