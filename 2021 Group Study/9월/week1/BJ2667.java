package com._0907.bj;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_bj_2667_이홍준 {
    static int Total = 0;
    static int Cnt = 0;
    final static int[] dr = {-1,1,0,0};
    final static int[] dc = {0,0,-1,1};
    static int[][] mat;
    static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        mat = new int[N][N];
        for(int i = 0; i < N ; i++){
            char[] line = sc.nextLine().toCharArray();
            for(int j = 0 ; j < N ; j++)
                mat[i][j]=line[j]-'0';
        }
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(mat[i][j]==1){
                    Cnt=1;
                    Total++;
                    dfs(i,j);
                    list.add(Cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(Total);
        for (int num : list) System.out.println(num);
    }
    public static void dfs(int row,int col){
        mat[row][col] = 0;
        for(int i = 0 ; i < 4 ; i++){
            int nr = row+dr[i];
            int nc = col+dc[i];
            if(nr>=0 && nr<N && nc>=0 && nc < N &&mat[nr][nc]==1){
                Cnt++;
                dfs(nr,nc);
            }
        }
    }
}

