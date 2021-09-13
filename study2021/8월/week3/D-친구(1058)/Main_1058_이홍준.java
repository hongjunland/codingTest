package com.backjoon._8월3주차._1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1058_이홍준 {
    static char[][] Mat;
    static boolean[] visited;
    static int Cnt;
    static int Max;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Mat = new char[N][N];
        for (int i = 0; i < N; i++) {
            Mat[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            Cnt = 0;
            visited = new boolean[N];
            visited[i] = true;
            dfs(0, i);
            Max = Integer.max(Max, Cnt);
        }
        System.out.println(Max);
    }

    public static void dfs(int d, int v) {
        if (d == 2) return;
        for (int i = 0; i < N; i++) {
            if (Mat[v][i] == 'Y') {
                if (!visited[i]) {
                    Cnt++;
                    visited[i] = true;
                }
                dfs(d + 1, i);
            }
        }
    }
}
