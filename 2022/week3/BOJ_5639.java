package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_5639 {
    static class Node{
        int left;
        int right;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static List<Integer> nums = new LinkedList<>();
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=br.readLine())!=null){
            int num = Integer.parseInt(str);
            pq.offer(num);
            if(num==pq.peek() && pq.size()>1){
                System.out.println(pq.poll());
            }
        }
//        N = nums.size();
//        for(int i = 0 ; i < N-1 ; i++){
//            if(nums.get(i)>)
//        }
    }
}
