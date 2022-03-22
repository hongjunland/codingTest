package week7;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers_42627 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }
}
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int current = 0;
        int cnt = 0;
        Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0]));
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int i = 0;
        while (cnt < jobs.length){
            while (i< jobs.length && jobs[i][0]<=current){
                pq.offer(new Job(jobs[i][0],jobs[i][1]));
                i++;
            }
            if(pq.isEmpty()){
                current = jobs[i][0];
            }else{
                Job job = pq.poll();
                answer += job.time + current - job.start;
                current += job.time;
                cnt++;
            }
        }
        return answer/jobs.length;
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
            return time-o.time;
        }
    }
}