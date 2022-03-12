package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17298 {
    static int N;
    static int[] nums;
    static int[] NGE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        NGE = new int[N+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            NGE[i] = -1;
            nums[i] = Integer.parseInt(st.nextToken());
            while (!pq.isEmpty() && pq.peek().value < nums[i]){
                Pair pair = pq.poll();
                NGE[pair.idx] = nums[i];
            }
            pq.add(new Pair(i,nums[i]));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(NGE[i]+" ");
        }
        System.out.println(sb);
    }
    static class Pair implements Comparable<Pair>{
        int idx;
        int value;

        public Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(value,o.value);
        }
    }
}
