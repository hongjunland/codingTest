package com.backjoon._1024;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1024_이홍준 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int L = Integer.parseInt(line[1]);
        int size = L;
        sb.append(-1);
        A: while (size<=100){
            for(int i = 0; i < N; i++){
                if(getSum(i,size)>N)break;
                if(getSum(i,size)==N){
                    sb = new StringBuilder();
                    for(int j = i ; j < i+size; j++) sb.append(j+" ");
                    break A;
                }
            }
            size++;
        }
        System.out.println(sb);
    }
    public static int getSum(int start, int size){
        return (2*start+size-1)*size/2;
    }
}
