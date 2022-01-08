import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1389 {
    static int N, M;
    static List<Edge>[] Graph;
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
            Graph[from].add(new Edge(to,1));
            Graph[to].add(new Edge(from,1));
        }
        for (int i = 1 ; i <= N ; i++){
//            System.out.println(total);
            int total = bfs(i);
            if (Min>total){
                Min = total;
                MinIdx = i;
            }
        }
        System.out.println(MinIdx);
    }
    static int bfs(int start){
        boolean[] visited = new boolean[N+1];
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(i,0));
        visited[i] = true;
        int total = 0;
        while (!queue.isEmpty()){
            Edge edge = queue.poll();
            for(Edge newEdge : Graph[edge.target]){
                if(!visited[newEdge.target]){
                    visited[newEdge.target] = true;
                    total+=edge.cost+1;
                    queue.offer(new Edge(newEdge.target,edge.cost+1));
                }
            }
        }
        return total;
    }
    static class Edge{
        int target;
        int cost;
        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
}
