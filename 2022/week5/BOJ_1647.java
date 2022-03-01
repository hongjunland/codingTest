import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647 {
    static int V,E;
    static PriorityQueue[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new PriorityQueue[V+1];
        for(int i = 1 ; i <= V ; i++){
            graph[i] = new PriorityQueue();
        }
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].offer(new Edge(from,to,weight));
            graph[to].offer(new Edge(to,from,weight));
        }
    }
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight,o.weight);
        }
    }
}
