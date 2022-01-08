package backjoon.d;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1021이홍준 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> targetQ = new LinkedList<>();
        for(int i = 0 ; i < M ; i++) {
            targetQ.add(Integer.parseInt(st.nextToken()));
        }
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            queue.add(i);
        }
        int result = 0;
        while (!targetQ.isEmpty()){
            int target = targetQ.peek();
            if(target==queue.peek()){
                targetQ.poll();
                queue.poll();
                continue;
            }
            int left = getIndex(queue,target);
            int right = (queue.size())-left;
            if(left < right){
                for(int i = 0 ; i < left ; i++){
                    shiftLeft(queue);
                    result++;
                }
            }else{
                for(int i = 0 ; i < right ; i++){
                    shiftRight(queue);
                    result++;
                }
            }
        }
        System.out.println(result);

    }
    public static int getIndex(Deque<Integer> q , int num){
        int result = 0;
        for(int n : q){
            if(n==num){
                break;
            }
            result++;
        }
        return result;
    }
    public static void shiftLeft(Deque<Integer> q){
        int head = q.poll();
        q.addLast(head);
    }
    public static void shiftRight(Deque<Integer> q){
        int tail = q.pollLast();
        q.addFirst(tail);
    }
}
