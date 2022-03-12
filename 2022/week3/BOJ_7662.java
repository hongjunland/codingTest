package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_7662 {
    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[N];
            PriorityQueue<Node> minPQ = new PriorityQueue<>();
            PriorityQueue<Node> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                switch (cmd) {
                    case 'I':
                        maxPQ.offer(new Node(i, num));
                        minPQ.offer(new Node(i, num));
                        break;
                    case 'D':
                        if (num == 1) {
                            while (!maxPQ.isEmpty()){
                                Node node = maxPQ.poll();
                                if(!visited[node.idx]){
                                    visited[node.idx] = true;
                                    break;
                                }
                            }
                        } else {
                            while (!minPQ.isEmpty()){
                                Node node = minPQ.poll();
                                if(!visited[node.idx]){
                                    visited[node.idx] = true;
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
            boolean flag = false;
            int Max = Integer.MIN_VALUE;
            int Min = Integer.MAX_VALUE;
            while (!maxPQ.isEmpty()) {
                Node node = maxPQ.poll();
                if (!visited[node.idx]) {
                    Max = Math.max(Max, node.num);
                    Min = Math.min(Min, node.num);
                    flag = true;
                }
            }
            while (!minPQ.isEmpty()) {
                Node node = minPQ.poll();
                if (!visited[node.idx]) {
                    Max = Math.max(Max, node.num);
                    Min = Math.min(Min, node.num);
                    flag = true;
                }
            }
            if (flag) {
                sb.append(Max + " " + Min);
            } else sb.append("EMPTY");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int idx;
        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(num, o.num);
        }
    }
}
