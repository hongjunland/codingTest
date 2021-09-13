package com.backjoon._8월3주차._1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1080_이홍준 {
    static int N;
    static int M;
    static char[][] initMat;
    static char[][] targetMat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        initMat = new char[N][M];
        targetMat = new char[N][M];
        for(int i = 0 ; i < N ; i++) initMat[i] = br.readLine().toCharArray();
        for(int i = 0 ; i < N ; i++) targetMat[i] = br.readLine().toCharArray();

        int result = 0;
        if(N>=3 && M>=3) {
            for (int i = 0; i < N - 2; i++) {
                for (int j = 0; j < M - 2; j++) {
                    if (initMat[i][j] != targetMat[i][j]) {
                        convert(i, j);
                        result++;
                    }
                }
            }
        }
        if(!isPair()) result = -1;
        System.out.println(result);
    }
    public static boolean isPair(){
        for(int i = 0 ; i < N ; i++){
            String a = String.valueOf(initMat[i]);
            String b = String.valueOf(targetMat[i]);
            if(!a.equals(b)) return false;
        }
        return true;
    }
    public static void convert(int r, int c){
        for(int i = 0 ; i < 3 ; i++){
            for (int j = 0; j < 3 ; j++) {
                if(i+r>=N || j+c>=M)continue;
                if(initMat[i+r][j+c]=='1') initMat[i+r][j+c]='0';
                else if(initMat[i+r][j+c]=='0') initMat[i+r][j+c]='1';
            }
        }
    }
}
