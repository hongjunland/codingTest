package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int N, X ,Y, M;
    static int[][] Mat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        Mat = new int[N+1][N+1];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Mat[x][y] = 1;
            Mat[y][x] = 1;
        }
        System.out.println(bfs(X,Y));
    }
    static int bfs(int start, int end){
        boolean[] visited = new boolean[N+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,0});
        visited[start] = true;
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int idx = pos[0];
            int depth = pos[1];
            if(idx==end){
                return depth;
            }
            for(int target = 1 ; target <= N ; target++){
                if(!visited[target] && Mat[idx][target]==1){
                    queue.offer(new int[]{target,depth+1});
                    visited[target] = true;
                }
            }
        }
        return -1;
    }
}
