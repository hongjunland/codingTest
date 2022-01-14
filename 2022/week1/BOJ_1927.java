import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            long x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()) sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");

            }
            else pq.offer(x);
        }
        System.out.println(sb);
    }
}
