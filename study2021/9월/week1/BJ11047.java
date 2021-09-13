package com._0907.bj;

import java.util.Scanner;
import java.util.Stack;

public class Main_bj_11047_이홍준 {
    static int N;
    static int K;
    static Stack<Integer>stack;
    static int Result=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            stack.push(sc.nextInt());
        }
        while (K!=0){
            Result += K/stack.peek();
            K = K%stack.pop();
        }
        System.out.println(Result);
    }
}

