package com.backjoon._2178;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] MAP;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        MAP = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0 ; i< N ; i++){
            String row = br.readLine();
            for(int j = 0 ;  j<M ; j++){
                MAP[i][j] = row.charAt(j)-'0';
            }
        }
        bfs();
        sb.append(MAP[N-1][M-1]);
        System.out.println(sb);
    }
    public static void bfs(){
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(0,0));
        while (!queue.isEmpty()){
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;
            for(int i = 0 ; i < 4 ; i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                if(0<=nr&&nr<N && 0<=nc&&nc<M && MAP[nr][nc]==1){
                    MAP[nr][nc] = MAP[row][col]+1;
                    queue.offer(new Location(nr,nc));
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
