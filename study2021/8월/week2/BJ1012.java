package com.backjoon._1012;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1012_이홍준 {
    static int[] dc = {0,0,-1,1};
    static int[] dr = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0 ; test_case < T ; test_case++){
            String[] line = br.readLine().split(" ");
            int M = Integer.parseInt(line[0]);  //가로
            int N = Integer.parseInt(line[1]);  //세로
            int K = Integer.parseInt(line[2]);  //배추위치
            int[][] map = new int[N][M];
            for(int i = 0 ; i < K ; i++){
                String[] str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                map[y][x] = 1;
            }
            int cnt = 0;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++ ){
                    if(map[i][j]==1){
                        bfs(map,i,j);
                        map[i][j]=1;
                        cnt++;
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int[][] map, int r, int c){
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(r,c));
        map[r][c] = 0;
        while (!queue.isEmpty()){
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;
            for(int i = 0 ; i < 4 ; i++){
                int nr = row+ dr[i];
                int nc = col+ dc[i];
                if(0<=nr && nr<map.length && 0<=nc && nc<map[0].length && map[nr][nc]==1){
                    queue.offer(new Location(nr,nc));
                    map[nr][nc] = 0;
                }
            }
        }
    }
}

class Location{
    int row;
    int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
