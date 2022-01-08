import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1389 {
    static int N, M;                        // N : number of vertex, M : number of edge
    static List<Integer>[] Graph;
    static int MinIdx = -1;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new LinkedList[N+1];

        for (int i = 0 ; i <= N ; i++){
            Graph[i] = new LinkedList();
        }

        for(int i = 1 ; i <= M ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            Graph[from].add(to);
            Graph[to].add(from);
        }
        for (int i = 1 ; i <= N ; i++){
            int total = bfs(i);
            if (Min>total){
                Min = total;
                MinIdx = i;
            }
        }
        System.out.println(MinIdx);
    }
    static int bfs(int start){
        boolean[] visited = new boolean[N+1];           // Check whether or not to visit.
        int[] dist = new int[N+1];                      // Distance from departure
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int sum = 0;
        while (!queue.isEmpty()){
            int current = queue.poll();
            for(int next : Graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[current]+1;
                    sum+=dist[next];
                    queue.offer(next);
                }
            }
        }
        return sum;
    }
}
