package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    static int F,S,G,U,D;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F+1];
        int result = bfs();
        if(result==-1) System.out.println("use the stairs");
        else System.out.println(result);
    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        visited[S] = true;
        queue.offer(new int[]{S,0});
        int[] dFloor = {U,-D};
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0]==G)
                return current[1];
            for(int i = 0 ; i < 2 ; i++){
                int nextFloor = current[0]+dFloor[i];
                if(nextFloor>0 && nextFloor<=F && !visited[nextFloor]){
                    visited[nextFloor] = true;
                    queue.offer(new int[]{nextFloor,current[1]+1});
                }
            }
        }
        return -1;
    }
}
// 1 3 5 7 9 8 10
