package week7;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Programmers_42627 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }
}
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        for (int i = 0 ; i < jobs.length ; i++){
            pq.offer(new Job(jobs[i][0], jobs[i][1]));
        }
        int current = 0;
        int answer = 0;
        while (!pq.isEmpty()){
//            Queue<Job> queue = new LinkedList<>();
//            while(!pq.isEmpty() && pq.peek().start>current){
//                queue.offer(pq.poll());
//            }
//            if(queue.size()>0 && pq.size()==0){
//                current++;
//                continue;
//            }
            Job job = pq.poll();
            answer += (current+job.time-job.start);
            current += job.time;
        }
        return answer / jobs.length;
    }
    class Job implements Comparable<Job>{
        int start;
        int time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
        @Override
        public int compareTo(Job o) {
            int cmp = Integer.compare(time+start,o.time+o.start);
            return cmp!=0 ? cmp : Integer.compare(start,o.start);
        }
    }
}
