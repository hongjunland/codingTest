
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static List<int[]> cases;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        char[] stdOp = {'+','-','*','/'};
        int[] ops = new int[N-1];
        int idx = 0 ;
        for(int i = 0 ; i < 4 ; i++){
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < cnt ; j++){
                ops[idx++] = i;
            }
        }
        int output[] = new int [N-1];
        boolean visited[] = new boolean [N-1];
        cases = new ArrayList<>();
        permutation(ops, output, visited, 0, N-1, N-1);
        PriorityQueue<Integer> maxPq = new PriorityQueue();
        PriorityQueue<Integer> minPq = new PriorityQueue();
        for(int[] arr : cases){
            int sum = nums[0];
            for(int i = 0 ; i < N-1 ; i++){
                char op = stdOp[arr[i]];
                sum = calculate(sum,nums[i+1],op);
            }
            maxPq.add(-sum);
            minPq.add(sum);
        }
        System.out.println(-maxPq.poll());
        System.out.println(minPq.poll());
    }
    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            cases.add(output.clone());
            return;
        }
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;;
            }
        }
    }
    public static int calculate(int a, int b , char c){
        int result = 0 ;
        switch (c){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
        }
        return result;
    }

}
